package com.mana.spring.service.impl;

import com.mana.spring.dao.AdminTokenDAO;
import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.*;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.NewUserDTOConverter;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.dto.UserDTOConverter;
import com.mana.spring.service.EmailService;
import com.mana.spring.service.UserService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AdminTokenDAO adminTokenDAO;


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
            String ENDL = System.getProperty("line.separator");
            String text = "Hi " + newUserDTO.getUserFirstName() + "," + ENDL + ENDL + " Your account setup is complete in admin dzi creations system. Welcome to the team. " + ENDL + ENDL + ENDL + ENDL + " This is an automatically generated message from DZI Creations. Replies are not monitored or answered.";
            emailService.sendSimpleMessage(newUserDTO.getUserEmail(), "Welcome to Admin DZI Creations!", text);
        } catch (Exception ex) {
            ex.fillInStackTrace();
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

    public void updatePassword(User user) {
        userDAO.updatePassword(user);

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
        System.out.println("username : " + username);
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
        ArrayList<User> users = (ArrayList<User>) userDAO.listAdminUser();
        return users;
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

}
