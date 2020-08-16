package com.mana.spring.web;

import com.mana.spring.util.JwtTokenUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    public HttpHeaders getJsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> apiLoginPage() {
        System.out.println("This is Login Page");
        return new ResponseEntity<String>(getJsonHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "adm/login-check", method = RequestMethod.GET)
    public ResponseEntity<String> thisIsAdminLoginCheck() {
        System.out.println("This is ADMIN Login Check");
        return new ResponseEntity<String>("{\"success\" : false, \"message\" : \"authentication-failure\"}", getJsonHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "cus/login-check", method = RequestMethod.GET)
    public ResponseEntity<String> thisIsCustomerLoginCheck() {
        System.out.println("This is CUSTOMER Login Check");
        return new ResponseEntity<String>("{\"success\" : false, \"message\" : \"authentication-failure\"}", getJsonHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public ResponseEntity apiAuthenticationFailure() {
        System.out.println("This is Auth Fail");
        return new ResponseEntity("Authentication Failed", HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/login-success", method = RequestMethod.GET)
    public ResponseEntity apiDefaultTarget() {

        System.out.println("This is Login Default");
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        return new ResponseEntity(jwtTokenUtil.generateToken(), HttpStatus.OK);
    }

    @RequestMapping(value = "cus/refresh-token", method = RequestMethod.GET)
    public ResponseEntity refreshToken() {

        System.out.println("This is Token Refresh");
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        return new ResponseEntity(jwtTokenUtil.generateToken(), HttpStatus.OK);
    }


}
