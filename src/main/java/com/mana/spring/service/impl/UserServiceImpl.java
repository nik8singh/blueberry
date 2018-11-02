package com.mana.spring.service.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.User;
import com.mana.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userDAO.listUser();
    }

    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }


}
