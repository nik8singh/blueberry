package com.mana.spring.dao;

import com.mana.spring.domain.User;

import java.util.List;

public interface UserDAO {

    List listUser(int start, int end);

    User getUserByEmail(String email);

    User getUserCart(String email);

    User getUserInvoices(String email);

    void saveUser(User user);

    void deleteUser(String email);

    void updateUser(User user);

    void updatePassword(User user);
}
