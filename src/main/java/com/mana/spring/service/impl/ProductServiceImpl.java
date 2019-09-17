package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductListDTO;
import com.mana.spring.dto.ProductRepoFilter;
import com.mana.spring.service.ProductService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ProductListDTO getAllProducts(int pageNumber) {

        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countAll());
        productListDTO.setProducts((ArrayList<Product>) productDAO.listAllProducts((pageNumber - 1) * size, size));
        return productListDTO;
    }

    public ProductListDTO getFeaturedProducts() {
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setProducts((ArrayList<Product>) productDAO.listFeaturedProducts());
        return productListDTO;
    }

    public ProductListDTO getInStockProducts(int pageNumber) {
        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countInStock(true));
        productListDTO.setProducts((ArrayList<Product>) productDAO.listInStockProducts((pageNumber - 1) * size, size));

        return productListDTO;
    }

    public ProductListDTO getNonPublishedProducts(int pageNumber) {
        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countPublished(false));
        productListDTO.setProducts((ArrayList<Product>) productDAO.listNonPublishedProducts((pageNumber - 1) * size, size));
        return productListDTO;
    }

    public ProductListDTO getPublishedProducts(int pageNumber) {
        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countPublished(true));
        productListDTO.setProducts((ArrayList<Product>) productDAO.listPublishedProducts((pageNumber - 1) * size, size));
        return productListDTO;
    }

    public ProductListDTO getOutOfStockProducts(int pageNumber) {
        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countInStock(false));
        productListDTO.setProducts((ArrayList<Product>) productDAO.listOutOfStockProducts((pageNumber - 1) * size, size));
        return productListDTO;
    }

    public ProductListDTO getFilteredProducts(int pageNumber, ProductRepoFilter repoFilter) {
        int size = Pagination.getPageSize();
        ProductListDTO productListDTO = createListDTO(pageNumber, productDAO.countFiltered(repoFilter));
        productListDTO.setProducts((ArrayList<Product>) productDAO.listFilteredProducts((pageNumber - 1) * size, size,repoFilter ));

        return productListDTO;
    }

    public Product addProduct(Product product) {
        return productDAO.saveProduct(product);
    }

    public Product updateProduct(Product updatedProduct) {
        Product productFromDb = productDAO.getProduct(updatedProduct.getProductId()); // true to keep fetch type EAGER
        productFromDb.setProductName(updatedProduct.getProductName());
        productFromDb.setProductDescription(updatedProduct.getProductDescription());
        productFromDb.setProductWeight(updatedProduct.getProductWeight());
        productFromDb.setWeightUnit(updatedProduct.getWeightUnit());
        productFromDb.setProductPrice(updatedProduct.getProductPrice());
        productFromDb.setProductSku(updatedProduct.getProductSku());
        productFromDb.setProductCurrency(updatedProduct.getProductCurrency());
        productFromDb.setProductQuantity(updatedProduct.getProductQuantity());
        productFromDb.setProductQuantityType(updatedProduct.getProductQuantityType());
        productFromDb.setProductOnFeatured(updatedProduct.isProductOnFeatured());
        productFromDb.setProductPublished(updatedProduct.isProductPublished());
        productFromDb.setProductExpense(updatedProduct.getProductExpense());
        productFromDb.setProductAcceptCoupon(updatedProduct.isProductAcceptCoupon());

        productFromDb.setProductJewelryType(updatedProduct.getProductJewelryType());
        productFromDb.setGemstones(updatedProduct.getGemstones());
        productFromDb.setMetals(updatedProduct.getMetals());

        productFromDb.setCreatedDate(null);
        productFromDb.setUpdatedDate(null);
        return productDAO.updateProduct(productFromDb);
    }

    public Product getProduct(Long productId) {
        return productDAO.getProduct(productId); // true to keep fetch type EAGER
    }

    public Product getProductByName(String name) {
        return productDAO.getProductByName(name); // true to keep fetch type EAGER
    }

    private ProductListDTO createListDTO(int pageNumber, long count) {
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setCount(count);
        productListDTO.setCurrentPageNumber(pageNumber);
        productListDTO.calculateAndSetTotalPages();

        return productListDTO;
    }

}
