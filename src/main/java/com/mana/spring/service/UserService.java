package com.mana.spring.service;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.User;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers(int pageNumber);

    ArrayList<CartItem> getUserCart(String email);

//    ArrayList<Invoice> getUserInvoices(String email);

    boolean registerUser(NewUserDTO newUserDTO, boolean admin, String token);

    void updateUser(User user);

    void deactivateUser(User user);

    void activateUser(User user);

    boolean updatePassword(NewUserDTO newUserDTO, String token);

    UserDetails loadUserByUsername(String username);

    UserDTO getUserByEmail(String username);

    boolean validateToken(String token);

    ArrayList<User> getAdminUsers();

    void sendPasswordResetEmail(String email);

    boolean validatePasswordForCheckout(String email, String password);

    void updatePrivateNote(String message, long id);

}
