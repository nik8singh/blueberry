package com.mana.spring.service.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.Address;
import com.mana.spring.domain.Shop;
import com.mana.spring.domain.User;
import com.mana.spring.dto.AddressDTO;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.service.UserService;
import com.mana.spring.util.ConverterDAOtoDTO;
import com.mana.spring.util.ConverterDTOtoDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public ArrayList<User> getUsers(int pageNumber) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public User getUserCart(String email) {
        return null;
    }

    public User getUserInvoices(String email) {
        return null;
    }

    public void registerUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public void updatePassword(User user) {

    }

    public void addAddress(User user) {

    }

    //    public ArrayList<User> getUsers() {
//        return null;
//    }
//
//    public void addUser(User user) {
//        userDAO.saveUser(user);
//    }
//
//    public void updateUser(User user) {
//
//        User userFromdb = userDAO.getUserByEmail(user.getUserEmail());
//        if (user.getUserFirstName() != null)
//            userFromdb.setUserFirstName(user.getUserFirstName());
//        if (user.getUserLastName() != null)
//            userFromdb.setUserLastName(user.getUserLastName());
//        if (user.getAuthorizationLevel() != null)
//            userFromdb.setAuthorizationLevel(user.getAuthorizationLevel());
//        user.setCreatedDate(null);
//        user.setUpdatedDate(null);
//        System.out.println("Ready to update : " + user);
//        userDAO.updateUser(user);
//    }
//
//    public void deleteUser(User user) {
//        userDAO.deleteUser(user.getUserEmail());
//    }
//
//    public void updatePassword(User user) {
//        userDAO.updatePassword(user);
//    }
//
//    public void addAddress(User user) {
//
//        // original
//        User userFromDB = userDAO.getUserByEmail(user.getUserEmail());
//        Set<Address> addresses = user.getAddresses();
//
//        // add new to original
//        for (Address address : user.getAddresses()) {
//            address.setUser(user);
//            addresses.add(address);
//        }
//
//        // save new to original
//        user.setAddresses(addresses);
//        user.setCreatedDate(null);
//        user.setUpdatedDate(null);
//
//        System.out.println("Saving user: " + user);
//
//
//        userDAO.updateUser(user);
//
//    }
//
//    public User getUserByEmail(String email) {
//        User user =userDAO.getUserByEmail(email);
//        Set<Address> addresses = user.getAddresses();
//
//        for (Address address : addresses)
//            if (!address.isActive())
//                addresses.remove(address);
//
//        return user;
//    }


}
