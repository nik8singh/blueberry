package com.mana.spring.service;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers(int pageNumber);

    ArrayList<CartItem> getUserCart(String email);

    ArrayList<Invoice>  getUserInvoices(String email);

    boolean registerUser(User user, boolean admin);

    void updateUser(User user);

    void deactivateUser(User user);

    void updatePassword(User user);

}
