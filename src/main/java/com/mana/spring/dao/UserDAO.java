package com.mana.spring.dao;

import com.mana.spring.domain.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(String email);

    List listUser();

    User getUserByEmail(String email);

    void updatePassword(User user);
}
