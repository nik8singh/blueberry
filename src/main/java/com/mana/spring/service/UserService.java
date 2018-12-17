package com.mana.spring.service;

import com.mana.spring.domain.User;
import com.mana.spring.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> getUsers();

    void addUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    void updatePassword(UserDTO userDTO);

    UserDTO getUserByEmail(String email);

    void addAddress(UserDTO userDTO);

}
