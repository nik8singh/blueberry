package com.mana.spring.web;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.Invoice;
import com.mana.spring.domain.User;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.UserDTO;
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

    @RequestMapping(value = "adm/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<User> getAllAdminUsers() {
        return userService.getAdminUsers();
    }

    @RequestMapping(value = "cus/user", method = RequestMethod.GET)
    public UserDTO getUserByEmail(@RequestParam String e) {
        return userService.getUserByEmail(e);
    }

    @RequestMapping(value = "cus/cart", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<CartItem> getUserCart(@RequestParam String e) {
        return userService.getUserCart(e);
    }

    @RequestMapping(value = "cus/orders", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Invoice> getUserOrders(@RequestParam String e) {
        return userService.getUserInvoices(e);
    }

    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public ResponseEntity registerUser(@Valid @RequestBody NewUserDTO user) {
        boolean newUser = userService.registerUser(user, false, null);
        // newUser is false if account was deactivated in past
        if (newUser)
            return new ResponseEntity(true, HttpStatus.OK);
        else
            return new ResponseEntity(false, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/register/save/admin/{token}", method = RequestMethod.POST)
    public ResponseEntity registerAdminUser(@PathVariable String token, @RequestBody NewUserDTO newUserDTO) {
        System.out.println(newUserDTO);
        if (!userService.validateToken(token)) {
            return new ResponseEntity("Token is incorrect or expired", HttpStatus.UNAUTHORIZED);
        }

        boolean newUser = userService.registerUser(newUserDTO, true, token);

        // newUser is false if account was deactivated in past
        if (newUser)
            return new ResponseEntity("User account is active now", HttpStatus.OK);
        else
            return new ResponseEntity("Account with this email already exists", HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "cus/deactivate", method = RequestMethod.DELETE)
    public ResponseEntity deactivateUser(@RequestBody User user) {
        userService.deactivateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/activate", method = RequestMethod.POST)
    public ResponseEntity activateUser(@RequestBody User user) {
        userService.activateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/updatepw", method = RequestMethod.DELETE)
    public ResponseEntity updatePassword(@RequestBody User user) {
        userService.updatePassword(user);
        return new ResponseEntity(HttpStatus.OK);
    }

}
