package com.mana.spring.service.impl;

import com.mana.spring.dao.AdminTokenDAO;
import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.*;
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
            return true;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUserPassword(encoder.encode(user.getUserPassword()));
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username Email: " + username + " DAO: " + userDAO);
        User user = userDAO.getUserByEmail(username);
        System.out.println(user);
        if (user != null) {
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(user);
            return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), !user.isDeleted(), true
                    , true, true, simpleGrantedAuthorities);
        }
        throw new UsernameNotFoundException("No User Found with username: " + username);


    }

    @Override
    public boolean validateToken(String token) {
        ArrayList<AdminToken> activeTokens
                = (ArrayList<AdminToken>) adminTokenDAO.listActiveTokens();

        for (AdminToken at : activeTokens) {
            if (at.getAdminToken().equals(token))
                return true;
        }

        return false;
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
