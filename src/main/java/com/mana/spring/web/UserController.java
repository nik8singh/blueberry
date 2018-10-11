package com.mana.spring.web;

import com.mana.spring.domain.Metal;
import com.mana.spring.domain.User;
import com.mana.spring.service.MetalService;
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
    public ResponseEntity saveUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }


}
