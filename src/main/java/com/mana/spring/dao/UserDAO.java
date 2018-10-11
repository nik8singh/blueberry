package com.mana.spring.dao;

import com.mana.spring.domain.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List listUser();
}
