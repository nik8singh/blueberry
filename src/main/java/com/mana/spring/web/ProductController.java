package com.mana.spring.web;

import com.mana.spring.domain.Product;
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

    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ArrayList<Product> getAllProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity saveProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }


}
