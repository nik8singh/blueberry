package com.mana.spring.service.impl;

import com.mana.spring.dao.AdminTokenDAO;
import com.mana.spring.dao.PasswordResetDAO;
import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.*;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.NewUserDTOConverter;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.dto.UserDTOConverter;
import com.mana.spring.service.EmailService;
import com.mana.spring.service.UserService;
import com.mana.spring.util.Pagination;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AdminTokenDAO adminTokenDAO;


    @Autowired
    private PasswordResetDAO passwordResetDAO;


    @Autowired
    public EmailService emailService;

    public ArrayList<User> getUsers(int pageNumber) {
        int size = Pagination.getPageSize();
        return (ArrayList<User>) userDAO.listUser((pageNumber - 1) * size, size);
    }

    public ArrayList<CartItem> getUserCart(String email) {
        return new ArrayList<>(userDAO.getUserCart(email).getCartItems());
    }

    public ArrayList<Invoice> getUserInvoices(String email) {
        return new ArrayList<>(userDAO.getUserInvoices(email).getInvoices());
    }

    // returns true if new user
    public boolean registerUser(NewUserDTO newUserDTO, boolean admin, String token) {
        User checkIfUserExists = userDAO.getUserByEmail(newUserDTO.getUserEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // If user exists and is deleted
        if (checkIfUserExists != null && checkIfUserExists.isDeleted()) {
            // send email to verify account to enable it again.
            return false;
        } else if (checkIfUserExists != null && !checkIfUserExists.isDeleted()) {
            // If user exists and is not deleted. [USER ALREADY EXISTS]
            return false;
        }
        //If new user
        User user = NewUserDTOConverter.convertToDomain(newUserDTO);
        Set<UserAuthority> auths = new HashSet<>();
        UserAuthority auth = new UserAuthority(user, false);
        auths.add(auth);
        if (admin) {
            auth = new UserAuthority(user, true);
            auths.add(auth);
        }
        user.setUserAuthorities(auths);
        user.setUserPassword(encoder.encode(newUserDTO.getUserPassword()));

        userDAO.saveUser(user);
        adminTokenDAO.delete(token);

        try {
            emailService.sendSimpleMessage(newUserDTO.getUserEmail(), "Welcome to Admin DZI Creations!", generatePWResetEmail(true, newUserDTO.getUserFirstName(), newUserDTO.getUserEmail(), null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public void updateUser(User user) {
        User currentUser = userDAO.getUserByEmail(user.getUserEmail());
        currentUser.setUserFirstName(user.getUserFirstName());
        currentUser.setUserLastName(user.getUserLastName());
        currentUser.setCreatedDate(null);
        currentUser.setUpdatedDate(null);
        userDAO.updateUser(currentUser);
    }

    public void deactivateUser(User user) {
        userDAO.deactivateUser(user.getUserEmail());

    }

    @Override
    public void activateUser(User user) {
        userDAO.activateUser(user.getUserEmail());
    }

    public boolean updatePassword(NewUserDTO newUserDTO, String token) {
        PasswordReset passwordReset = passwordResetDAO.getPasswordReset(token);

        if (passwordReset == null)
            return false;
        if (passwordReset.getExpiration().before(new Date()) || !passwordReset.isActive())
            return false;

        User user = new User();
        user.setUserEmail(passwordReset.getPasswordResetUser().getUserEmail());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUserPassword(encoder.encode(newUserDTO.getUserPassword()));

        userDAO.updatePassword(user);
        passwordResetDAO.deleteToken(token);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByEmail(username);
        if (user != null) {
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(user);
            return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), !user.isDeleted(), true
                    , true, true, simpleGrantedAuthorities);
        }
        throw new UsernameNotFoundException("No User Found with username: " + username);
    }

    @Override
    public UserDTO getUserByEmail(String username) {
        return UserDTOConverter.convertToDTO(userDAO.getUserByEmail(username));
    }

    @Override
    public boolean validateToken(String token) {
        ArrayList<AdminToken> activeTokens
                = (ArrayList<AdminToken>) adminTokenDAO.listActiveTokens();

        for (AdminToken at : activeTokens) {
            if (at.getAdminToken().equals(token)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<User> getAdminUsers() {
        return (ArrayList<User>) userDAO.listAdminUser();
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        User user = userDAO.getUserByEmail(email);
        if (user == null)
            return;

        PasswordReset passwordReset = new PasswordReset();
        passwordReset.setPasswordResetUser(user);
        passwordReset.setActive(true);
        passwordReset.setExpiration(DateUtils.addHours(new Date(), 1));
        Random random = new Random();
        String generatedString = random.ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        passwordReset.setToken(generatedString);
        passwordResetDAO.savePasswordReset(passwordReset);

        try {
            emailService.sendSimpleMessage(user.getUserEmail(), "Reset Password for your DZI Creations Account", generatePWResetEmail(false, user.getUserFirstName(), user.getUserEmail(), passwordReset.getToken()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        if (user.getUserAuthorities() != null) {
            for (UserAuthority role : user.getUserAuthorities()) {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
        }
        return simpleGrantedAuthorities;
    }

    private String generatePWResetEmail(boolean welcome, String firstName, String email, String token) {
        String title, bodyPara1, bodyPara2, bodyPara3, button, buttonURL;
        if (welcome) {
            title = "Welcome to DZI Creations!";
            bodyPara1 = "Hi " + firstName + ",";
            bodyPara2 = "Welcome to DZI creations online store.";
            bodyPara3 = "Your profile has been activated for, " + email.toLowerCase();
            button = "Activate Account";
            buttonURL = "#";

        } else {
            title = "Password reset was requested for your DZI Creations account";
            bodyPara1 = "Hi " + firstName + ",";
            bodyPara2 = "A password reset request was made for your DZI Creations account. If you did not make this request, please contact us at contact@dzicreations.com";
            bodyPara3 = "Click this link to reset the password for your email, " + email.toLowerCase() + ":";
            button = "Reset Password";
            buttonURL = "http://localhost/dziadmin/resetPassword.html?tk=" + token;
        }


        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\"><head><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/><meta content=\"width=device-width\" name=\"viewport\"/><meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/><title></title><link href=\"https://fonts.googleapis.com/css?family=Oswald\" rel=\"stylesheet\" type=\"text/css\"/><link href=\"https://fonts.googleapis.com/css?family=Cabin\" rel=\"stylesheet\" type=\"text/css\"/><style type=\"text/css\">\n" +
                "\t\tbody {\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ttable,\n" +
                "\t\ttd,\n" +
                "\t\ttr {\n" +
                "\t\t\tvertical-align: top;\n" +
                "\t\t\tborder-collapse: collapse;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\t* {\n" +
                "\t\t\tline-height: inherit;\n" +
                "\t\t}\n" +
                "\n" +
                "\t\ta[x-apple-data-detectors=true] {\n" +
                "\t\t\tcolor: inherit !important;\n" +
                "\t\t\ttext-decoration: none !important;\n" +
                "\t\t}\n" +
                "\t</style><style id=\"media-query\" type=\"text/css\">\n" +
                "\t\t@media (max-width: 660px) {\n" +
                "\n" +
                "\t\t\t.block-grid,\n" +
                "\t\t\t.col {\n" +
                "\t\t\t\tmin-width: 320px !important;\n" +
                "\t\t\t\tmax-width: 100% !important;\n" +
                "\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.block-grid {\n" +
                "\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.col {\n" +
                "\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.col>div {\n" +
                "\t\t\t\tmargin: 0 auto;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\timg.fullwidth,\n" +
                "\t\t\timg.fullwidthOnMobile {\n" +
                "\t\t\t\tmax-width: 100% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col {\n" +
                "\t\t\t\tmin-width: 0 !important;\n" +
                "\t\t\t\tdisplay: table-cell !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack.two-up .col {\n" +
                "\t\t\t\twidth: 50% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num2 {\n" +
                "\t\t\t\twidth: 16.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num3 {\n" +
                "\t\t\t\twidth: 25% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num4 {\n" +
                "\t\t\t\twidth: 33% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num5 {\n" +
                "\t\t\t\twidth: 41.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num6 {\n" +
                "\t\t\t\twidth: 50% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num7 {\n" +
                "\t\t\t\twidth: 58.3% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num8 {\n" +
                "\t\t\t\twidth: 66.6% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num9 {\n" +
                "\t\t\t\twidth: 75% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.no-stack .col.num10 {\n" +
                "\t\t\t\twidth: 83.3% !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.video-block {\n" +
                "\t\t\t\tmax-width: none !important;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.mobile_hide {\n" +
                "\t\t\t\tmin-height: 0px;\n" +
                "\t\t\t\tmax-height: 0px;\n" +
                "\t\t\t\tmax-width: 0px;\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t\toverflow: hidden;\n" +
                "\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t}\n" +
                "\n" +
                "\t\t\t.desktop_hide {\n" +
                "\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\tmax-height: none !important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t</style></head><body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #ffffff;\"><table bgcolor=\"#ffffff\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; width: 100%;\" valign=\"top\" width=\"100%\"><tbody><tr style=\"vertical-align: top;\" valign=\"top\"><td style=\"word-break: break-word; vertical-align: top;\" valign=\"top\"><div style=\"background-color:transparent;overflow:hidden\"><div class=\"block-grid\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; width: 100%; background-color: #ffffff;\"><div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\"><div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\"><div style=\"width:100% !important;\"><div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><div style=\"color:#555555;font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\"><div style=\"line-height: 1.2; font-size: 12px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif; color: #555555; mso-line-height-alt: 14px;\"><p style=\"font-size: 34px; line-height: 1.2; font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif; word-break: break-word; mso-line-height-alt: 41px; margin: 0;\"><span style=\"font-size: 34px;\"><strong><span style=\"color: #000000;\">DZI Creations</span></strong></span></p></div></div><div style=\"color:#555555;font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\"><div style=\"line-height: 1.2; font-size: 12px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif; color: #555555; mso-line-height-alt: 14px;\"><p style=\"font-size: 22px; line-height: 1.2; word-break: break-word; font-family: 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Geneva, Verdana, sans-serif; mso-line-height-alt: 26px; margin: 0;\"><span style=\"font-size: 22px;\">" + title + "</span></p></div></div><div style=\"color:#555555;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\"><div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; mso-line-height-alt: 14px;\"><p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"></p><p style=\"line-height: 1.2; word-break: break-word; mso-line-height-alt: 14px; margin: 0;\"></p></div></div></div></div></div></div></div></div><div style=\"background-color:transparent;overflow:hidden\"><div class=\"block-grid\" style=\"min-width: 320px; max-width: 640px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; width: 100%; background-color: #ffffff;\"><div style=\"border-collapse: collapse;display: table;width: 100%;background-color:#ffffff;\"><div class=\"col num12\" style=\"min-width: 320px; max-width: 640px; display: table-cell; vertical-align: top; width: 640px;\"><div style=\"width:100% !important;\"><div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><div style=\"color:#ea7db4;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;line-height:1.2;padding-top:20px;padding-right:30px;padding-bottom:30px;padding-left:30px;\"><div style=\"line-height: 1.2; font-size: 12px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #ea7db4; mso-line-height-alt: 14px;\"><p style=\"font-size: 24px; line-height: 1.2; word-break: break-word; text-align: left; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; mso-line-height-alt: 29px; margin: 0;\"><span style=\"font-size: 24px; color: #000080;\">" + bodyPara1 + "</span></p><p style=\"font-size: 24px; margin-top: 50px; line-height: 1.2; word-break: break-word; text-align: left; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; mso-line-height-alt: 29px;\"><span style=\"font-size: 24px; color: #000080;\">" + bodyPara2 + "</span></p><p style=\"font-size: 24px; margin-top:50px; line-height: 1.2; word-break: break-word; text-align: left; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; mso-line-height-alt: 29px;\"><span style=\"font-size: 24px; color: #000080;\">" + bodyPara3 + "</span></p></div></div><div align=\"center\" class=\"button-container\" style=\"padding-top:30px;padding-right:10px;padding-bottom:45px;padding-left:10px;\"><a href=\"" + buttonURL + "\" style=\"-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #5f36ef; border-radius: 0px; -webkit-border-radius: 0px; -moz-border-radius: 0px; width: auto; width: auto; border-top: 1px solid #5f36ef; border-right: 1px solid #5f36ef; border-bottom: 1px solid #5f36ef; border-left: 1px solid #5f36ef; padding-top: 10px; padding-bottom: 10px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;\" target=\"_blank\"><span style=\"padding-left:50px;padding-right:50px;font-size:12px;display:inline-block;\"><span style=\"line-height: 24px; word-break: break-word; font-size:20px\">" + button + "</span></span></a></div><div style=\"color:#555555;font-family:Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\"><div style=\"line-height: 1.2; font-size: 12px; color: #555555; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; mso-line-height-alt: 14px;\"><p style=\"font-size: 14px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 17px; margin: 0;\">This is an automatically generated message from DZI Creations. Replies are not monitored or answered.<br/></p></div></div></div></div></div></div></div></div></td></tr></tbody></table></body></html>";
    }

}
