package com.mana.spring.service.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import com.mana.spring.domain.UserAuthority;
import com.mana.spring.service.UserService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

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
    public boolean registerUser(User user, boolean admin){
        User checkIfUserExists = userDAO.getUserByEmail(user.getUserEmail());

        if (checkIfUserExists != null && checkIfUserExists.isDeleted()) {
            checkIfUserExists.setUserLastName(user.getUserLastName());
            checkIfUserExists.setUserFirstName(user.getUserFirstName());
            checkIfUserExists.setUserPassword(user.getUserPassword());
            checkIfUserExists.setDeleted(false);
            checkIfUserExists.setCreatedDate(null);
            checkIfUserExists.setUpdatedDate(null);
            userDAO.updatePassword(checkIfUserExists);
            return false;
        }else if(checkIfUserExists != null && !checkIfUserExists.isDeleted()){
            return false;
        }

        Set<UserAuthority> auths = new HashSet<>();
        UserAuthority auth = new UserAuthority(user, false);
        auths.add(auth);
        if (admin) {
            auth = new UserAuthority(user, true);
            auths.add(auth);
        }
        user.setUserAuthorities(auths);
//        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userDAO.saveUser(user);
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

    public void updatePassword(User user) {
        userDAO.updatePassword(user);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("Email: " + email);
        User user = userDAO.getUserByEmail(email);
        UserBuilder userBuilder = null;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.disabled(user.isDeleted());
            userBuilder.password(user.getUserPassword());
            String[] authorities = user.getUserAuthorities()
                    .stream().map(UserAuthority::getRole).toArray(String[]::new);


            userBuilder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        System.out.println(user);

        return userBuilder.build();
    }
}
