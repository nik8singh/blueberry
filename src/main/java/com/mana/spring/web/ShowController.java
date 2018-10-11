package com.mana.spring.web;

import com.mana.spring.domain.Show;
import com.mana.spring.domain.User;
import com.mana.spring.service.ShowService;
import com.mana.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    public ShowService showService;

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Show> getAllShows() {
        return showService.getShows();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveShow(@RequestBody Show show) {
        System.out.println(show);
//        showService.addShow(show);
        return new ResponseEntity(show, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateShow(@RequestBody Show show) {
        showService.updateShow(show);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteShow(@RequestBody Show show) {
        showService.deleteShow(show);
        return new ResponseEntity(HttpStatus.OK);
    }


}
