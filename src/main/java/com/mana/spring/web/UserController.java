package com.mana.spring.web;

import com.mana.spring.domain.CartItem;
import com.mana.spring.domain.User;
import com.mana.spring.dto.NewUserDTO;
import com.mana.spring.dto.UserDTO;
import com.mana.spring.service.UserService;
import com.mana.spring.util.JwtTokenUtil;
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

//    @RequestMapping(value = "cus/orders", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    ArrayList<Invoice> getUserOrders(@RequestParam String e) {
//        return userService.getUserInvoices(e);
//    }

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
        if (!userService.validateToken(token)) {
            return new ResponseEntity("Token is incorrect or expired", HttpStatus.UNAUTHORIZED);
        }

        boolean newUser = userService.registerUser(newUserDTO, false, token);

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

    @RequestMapping(value = "updatepw/{token}", method = RequestMethod.POST)
    public ResponseEntity updatePassword(@PathVariable String token, @RequestBody NewUserDTO newUserDTO) {
        System.out.println("Token = " + token);
        boolean flag = userService.updatePassword(newUserDTO, token);
        if (flag)
            return new ResponseEntity("User password reset successful", HttpStatus.OK);
        else
            return new ResponseEntity("Something went wrong. Try again", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "pwresetrequest", method = RequestMethod.POST)
    public ResponseEntity passwordResetRequest(@RequestBody UserDTO userDTO) {
        userService.sendPasswordResetEmail(userDTO.getUserEmail());
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "cus/checkoutLogin", method = RequestMethod.GET)
    public ResponseEntity checkoutLogin(@RequestBody UserDTO userDTO) {
        if (userService.validatePasswordForCheckout(userDTO.getUserEmail(), userDTO.getUserPassword())) {
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            return new ResponseEntity(jwtTokenUtil.generateToken(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "adm/privateNote/{userId}", method = RequestMethod.POST)
    public ResponseEntity privateNoteUpdate(@RequestBody String message, @PathVariable long userId) {
        userService.updatePrivateNote(message, userId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
