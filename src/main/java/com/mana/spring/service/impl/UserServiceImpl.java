package com.mana.spring.service.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import com.mana.spring.service.UserService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public ArrayList<User> getUsers(int pageNumber) {
        int size = Pagination.getPageSize();
        ArrayList<User> users = (ArrayList<User>) userDAO.listUser((pageNumber - 1) * size, size);
        return users;
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public ArrayList<CartItem> getUserCart(String email) {
        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.addAll(userDAO.getUserCart(email).getCartItems());
        return cartItems;
    }

    public ArrayList<Invoice> getUserInvoices(String email) {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        invoices.addAll(userDAO.getUserInvoices(email).getInvoices());
        return invoices;
    }

    // returns true if new user
    public boolean registerUser(User user) {
        User checkIfUserExists = userDAO.getUserByEmail(user.getUserEmail());
        if (checkIfUserExists != null) {
            checkIfUserExists.setUserLastName(user.getUserLastName());
            checkIfUserExists.setUserFirstName(user.getUserFirstName());
            checkIfUserExists.setUserPassword(user.getUserPassword());
            checkIfUserExists.setDeleted(false);
            checkIfUserExists.setCreatedDate(null);
            checkIfUserExists.setUpdatedDate(null);
            userDAO.updatePassword(checkIfUserExists);
            return false;
        }
        user.setAuthorizationLevel("customer");
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

}
