package com.mana.spring.service;

import com.mana.spring.domain.User;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
