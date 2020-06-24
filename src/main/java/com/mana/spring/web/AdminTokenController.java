package com.mana.spring.web;

import com.mana.spring.domain.AdminToken;
import com.mana.spring.service.AdminTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admintoken")
public class AdminTokenController {

    @Autowired
    public AdminTokenService adminTokenService;

    @RequestMapping(value = "adm/generate", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    AdminToken generateAdminToken() {
        return adminTokenService.generate();
    }

    @RequestMapping(value = "adm/activeTokens", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<AdminToken> activeTokens() {
        return (ArrayList<AdminToken>) adminTokenService.listActiveTokens();
    }


}
