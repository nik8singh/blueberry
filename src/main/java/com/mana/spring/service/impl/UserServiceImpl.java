package com.mana.spring.service.impl;

import com.mana.spring.dao.UserDAO;
import com.mana.spring.domain.Address;
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

    public ArrayList<User> getUsers() {
        return null;
    }

    public void addUser(UserDTO userDTO) {
        userDAO.saveUser(ConverterDTOtoDAO.userDtoToDao(userDTO));
    }

    public void updateUser(UserDTO userDTO) {

        User user = userDAO.getUserByEmail(userDTO.getUserEmail());
        if (userDTO.getUserFirstName() != null)
            user.setUserFirstName(userDTO.getUserFirstName());
        if (userDTO.getUserLastName() != null)
            user.setUserLastName(userDTO.getUserLastName());
        if (userDTO.getAuthorizationLevel() != null)
            user.setAuthorizationLevel(userDTO.getAuthorizationLevel());
        user.setCreatedDate(null);
        user.setUpdatedDate(null);
        System.out.println("Ready to update : " + user);
        userDAO.updateUser(user);
    }

    public void deleteUser(UserDTO userDTO) {
        userDAO.deleteUser(userDTO.getUserEmail());
    }

    public void updatePassword(UserDTO userDTO) {
        userDAO.updatePassword(ConverterDTOtoDAO.userDtoToDao(userDTO));
    }

    public void addAddress(UserDTO userDTO) {

        // original
        User user = userDAO.getUserByEmail(userDTO.getUserEmail());
        Set<Address> addresses = user.getAddresses();

        // add new to original
        for (AddressDTO addressDTO : userDTO.getAddressesDto()) {
            Address target = new Address();
            BeanUtils.copyProperties(addressDTO, target);
            target.setUser(user);
            addresses.add(target);
        }

        // save new to original
        user.setAddresses(addresses);
        user.setCreatedDate(null);
        user.setUpdatedDate(null);

        System.out.println("Saving user: " + user);


        userDAO.updateUser(user);

    }

    public UserDTO getUserByEmail(String email) {
        UserDTO userDTO = ConverterDAOtoDTO.userDaoToDto(userDAO.getUserByEmail(email));
        Set<AddressDTO> addresses = userDTO.getAddressesDto();

        for (AddressDTO addressDTO : addresses)
            if (!addressDTO.isActive())
                addresses.remove(addressDTO);

        return userDTO;
    }


}
