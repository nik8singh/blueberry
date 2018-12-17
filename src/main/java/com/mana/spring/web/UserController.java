package com.mana.spring.web;

import com.mana.spring.domain.User;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<User> getAllUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity(userDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "updatepw", method = RequestMethod.DELETE)
    public ResponseEntity updatePassword(@RequestBody UserDTO userDTO) {
        userService.updatePassword(userDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "getuser", method = RequestMethod.GET)
    public UserDTO getUserByEmail(@RequestBody String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "addAddress", method = RequestMethod.POST)
    public ResponseEntity addAddress(@RequestBody UserDTO userDTO) {
        userService.addAddress(userDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
