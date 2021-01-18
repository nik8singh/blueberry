package com.mana.spring.web;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductDTO;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.dto.ProductMinimumListDTO;
import com.mana.spring.dto.ProductRepoFilter;
import com.mana.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProductService productService;


    @RequestMapping(value = "vis/p/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductDTO getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "vis/product/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Product getProductByName(@PathVariable String name) {

        return productService.getProductByName(name);
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

    @RequestMapping(value = "vis/list/filtered/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductMinimumListDTO getfilteredProducts(@PathVariable int pageNumber, @RequestBody ProductRepoFilter productRepoFilter) {
        return productService.getFilteredProducts(pageNumber, productRepoFilter);
    }

    @RequestMapping(value = "vis/list/published/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getPublishedProducts(@PathVariable int pageNumber) {
        return productService.getPublishedProducts(pageNumber);
    }

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
    public Product saveProduct( @Valid @RequestBody Product product) {

        return productService.addProduct(product);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        System.out.println(product);
        productService.updateProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/publish/{id}/{publishFlag}", method = RequestMethod.POST)
    public ResponseEntity updateProductPublish(@PathVariable Long id, @PathVariable Boolean publishFlag) {
        productService.updateProductPublish(id, publishFlag);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/list/search/{searchWord}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProductListDTO getPartialSearch(@PathVariable String searchWord) {
        return productService.partialSearch(searchWord);
    }
}
