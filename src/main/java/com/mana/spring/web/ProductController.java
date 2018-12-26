package com.mana.spring.web;

import com.mana.spring.dto.ProductDTO;
import com.mana.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;
//
//    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    ArrayList<ProductDTO> getAllProducts() {
//        return productService.getProducts();
//    }
//
//    @RequestMapping(value = "available", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    ArrayList<ProductDTO> getAvailableProducts() {
//        return productService.getAvailableProducts();
//    }
//
//    @RequestMapping(value = "product", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    ProductDTO getProduct(Long productId) {
//        return productService.getProduct(productId);
//    }
//
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO) {
//        productService.addProduct(productDTO);
//        return new ResponseEntity(productDTO, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO) {
//        productService.updateProduct(productDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
//    public ResponseEntity deleteProduct(@RequestBody ProductDTO productDTO) {
//        productService.deleteProduct(productDTO);
//        return new ResponseEntity(HttpStatus.OK);
//    }


}
