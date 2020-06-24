package com.mana.spring.web;

import com.mana.spring.domain.Image;
import com.mana.spring.dto.ImageListDTO;
import com.mana.spring.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    public ImageService imageService;

    @RequestMapping(value = "adm/{id}/upload", method = RequestMethod.POST)
    public ResponseEntity saveProductImage(@RequestParam(value = "file") MultipartFile file, @PathVariable long id) {
        return new ResponseEntity(imageService.addProductImage(file, id), HttpStatus.OK);
    }

    @RequestMapping(value = "adm/updatePriority", method = RequestMethod.POST)
    public ResponseEntity updateImagePriorityBulk(@RequestBody ImageListDTO imageListDTO) {
        imageService.updateImagePriorityBulk(imageListDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteImageByPublicId(@RequestParam(value = "p") String public_id) {

        imageService.deleteImageByPublicId(public_id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "adm/counter", method = RequestMethod.GET)
    public long imageCounter() {
        return imageService.getImageCounter();
    }

    @RequestMapping(value = "vis/image/{name}", method = RequestMethod.GET, produces = "application/json")
    public Image getImage(@PathVariable String name) {
        return imageService.getImage(name);
    }


    @RequestMapping(value = "vis/list/page/{pageName}", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Image> getPageImages(@PathVariable String pageName) {

        return imageService.getImagesByPage(pageName);
    }

    @RequestMapping(value = "vis/list/panel/{panelName}", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Image> getPanelImages(@PathVariable String panelName) {

        return imageService.getImagesByPanel(panelName);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateImage(@Valid @RequestBody Image image) {

        imageService.updateImage(image);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/delete/product/{productId}/{priority}", method = RequestMethod.POST)
    public ResponseEntity deleteImageByProductAndPriority(@PathVariable long productId, @PathVariable int priority) {

        boolean flag = imageService.deleteImageByProductPriority(productId, priority);

        if (flag)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @RequestMapping(value = "adm/delete/product/{panelName}/{priority}", method = RequestMethod.POST)
    public ResponseEntity deleteImageByPanelAndPriority(@PathVariable String panelName, @PathVariable int priority) {

        imageService.deleteImageByPanelPriority(panelName, priority);

        return new ResponseEntity(HttpStatus.OK);
    }

}
