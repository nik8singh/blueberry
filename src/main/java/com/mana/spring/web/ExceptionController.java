package com.mana.spring.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping(method = RequestMethod.OPTIONS, value = "/*")
    @ResponseBody
    public ResponseEntity handleOptions() {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
