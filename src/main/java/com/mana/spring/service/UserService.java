package com.mana.spring.service;

import com.mana.spring.domain.User;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers(int pageNumber);

    User getUserByEmail(String email);

    User getUserCart(String email);

    User getUserInvoices(String email);

    void registerUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void updatePassword(User user);

    void addAddress(User user);



}
