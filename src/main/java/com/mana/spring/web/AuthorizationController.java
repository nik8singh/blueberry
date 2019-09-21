package com.mana.spring.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    @RequestMapping(value = "login")
    public ResponseEntity needLoginToAccess(){
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "login/fail")
    public ResponseEntity notEnoughAuth(){
        return new ResponseEntity("Login required ",HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "login/success")
    public ResponseEntity loginSuccess(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "logout/success")
    public ResponseEntity logoutSuccess(){
        return new ResponseEntity(HttpStatus.OK);
    }


}
