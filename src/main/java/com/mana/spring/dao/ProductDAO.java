package com.mana.spring.dao;

import com.mana.spring.domain.Product;
import com.mana.spring.dto.ProductRepoFilter;

import java.util.List;

public interface ProductDAO {

    Product getProduct(Long productId);

    Product saveProduct(Product product);

    void updateProductPublish(Long productId, boolean publishFlag);

    void updateProduct(Product product);

    List listAllProducts(int start, int end);

    List listFeaturedProducts();

    List listInStockProducts(int start, int end);

    List listNonPublishedProducts(int start, int end);

    List listPublishedProducts(int start, int end);

    List listOutOfStockProducts(int start, int end);

    List listFilteredProducts(int start, int end, ProductRepoFilter repoFilter);

    long countAll();

    long countInStock(boolean inStock);

    long countPublished(boolean published);

    long countFiltered(ProductRepoFilter repoFilter);

    Product getProductByName(String name);

    void updateSKU(long id, String sku);

}
