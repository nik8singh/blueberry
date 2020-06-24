package com.mana.spring.service;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers(int pageNumber);

    ArrayList<CartItem> getUserCart(String email);

    ArrayList<Invoice>  getUserInvoices(String email);

    boolean registerUser(User user, boolean admin);

    void updateUser(User user);

    void deactivateUser(User user);

    void updatePassword(User user);

    UserDetails loadUserByUsername(String username);

    boolean validateToken(String token);

    ArrayList<User> getAdminUsers();
}
