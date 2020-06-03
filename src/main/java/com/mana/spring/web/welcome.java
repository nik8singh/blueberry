package com.mana.spring.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomeWorld() {
        return "Welcome Page";
    }

    @RequestMapping(value = {"/userpage"}, method = RequestMethod.GET)
    public String welcomeUser() {
        return "Welcome User";
    }

    @RequestMapping(value = "/adminpage", method = RequestMethod.GET)
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String welcomeLogout() {
        return "Welcome Logout";
    }

}
