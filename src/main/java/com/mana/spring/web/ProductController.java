package com.mana.spring.web;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;


    @RequestMapping(value = "vis/product/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Product getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }

    @RequestMapping(value = "adm/list/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getAllProducts(@PathVariable int pageNumber) {
        return productService.getAllProducts(pageNumber);
    }

    @RequestMapping(value = "vis/list/featured", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getFeaturedProducts() {
        return productService.getFeaturedProducts();
    }

    @RequestMapping(value = "vis/list/instock/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getInStockProducts(@PathVariable int pageNumber) {
        return productService.getInStockProducts(pageNumber);
    }

    @RequestMapping(value = "vis/list/published/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getPublishedProducts(@PathVariable int pageNumber) {
        return productService.getPublishedProducts(pageNumber);
    }
    /*

    Implement filtered list service

     */

    @RequestMapping(value = "adm/list/nonpublished/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getNonPublishedProducts(@PathVariable int pageNumber) {
        return productService.getNonPublishedProducts(pageNumber);
    }

    @RequestMapping(value = "adm/list/outofstock/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getOutOfStockProducts(@PathVariable int pageNumber) {
        return productService.getOutOfStockProducts(pageNumber);
    }

    @RequestMapping(value = "adm/save", method = RequestMethod.POST)
    public ResponseEntity saveGemstone(@RequestBody Product product) {

        productService.addProduct(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }
}
