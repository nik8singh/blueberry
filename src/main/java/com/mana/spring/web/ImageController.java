package com.mana.spring.web;

import com.mana.spring.dto.ImageDTO;
import com.mana.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    public ImageService imageService;

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public ResponseEntity saveImage(@RequestBody ImageDTO imageDTO) {
//
//        imageService.addImage(imageDTO);
//        return new ResponseEntity(imageDTO, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "siteImage", method = RequestMethod.GET, produces = "application/json")
//    public ArrayList<ImageDTO> getSiteImage(@RequestBody String siteLocation) {
//
//        return imageService.getSiteImages(siteLocation);
//    }
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public ResponseEntity updateImage(@RequestBody ImageDTO imageDTO) {
//
//        imageService.updateImage(imageDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "delete", method = RequestMethod.POST)
//    public ResponseEntity deleteImage(@RequestBody ImageDTO imageDTO) {
//
//        imageService.deleteImage(imageDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "deleteImPri", method = RequestMethod.POST)
//    public ResponseEntity deleteImageByProductAndPriority(@RequestBody ImageDTO imageDTO) {
//
//        imageService.deleteImageByProductPriority(imageDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

}
