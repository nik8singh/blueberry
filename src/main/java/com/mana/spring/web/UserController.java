package com.mana.spring.web;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import com.mana.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/list/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<User> getAllUsers(@PathVariable int pageNumber) {
        return userService.getUsers(pageNumber);
    }

//    @RequestMapping(value = "cus/user/{email}", method = RequestMethod.GET)
//    public User getUserByEmail(@PathVariable String email) {
//        return userService.getUserByEmail(email);
//    }

    @RequestMapping(value = "cus/cart/{email}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<CartItem> getUserCart(@PathVariable String email) {
        return userService.getUserCart(email);
    }

    @RequestMapping(value = "cus/orders/{email}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Invoice> getUserOrders(@PathVariable String email) {
        return userService.getUserInvoices(email);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity registerUser(@Valid @RequestBody User user) {
        boolean newUser = userService.registerUser(user, false);
        // newUser is false if account was deactivated in past
        if (newUser)
            return new ResponseEntity(newUser, HttpStatus.OK);
        else
            return new ResponseEntity(newUser, HttpStatus.FOUND);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity registerAdminUser(@RequestBody User user) {
        boolean newUser = userService.registerUser(user, true);
        // newUser is false if account was deactivated in past
        if (newUser)
            return new ResponseEntity(newUser, HttpStatus.OK);
        else
            return new ResponseEntity(newUser, HttpStatus.FOUND);
    }

    @RequestMapping(value = "cus/deactivate", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@RequestBody User user) {
        userService.deactivateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "updatepw", method = RequestMethod.DELETE)
    public ResponseEntity updatePassword(@RequestBody User user) {
        userService.updatePassword(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    public ResponseEntity sendAuth() {
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
