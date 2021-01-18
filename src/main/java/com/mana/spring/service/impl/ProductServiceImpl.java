package com.mana.spring.service.impl;

import com.mana.spring.dao.ProductDAO;
import com.mana.spring.domain.Gemstone;
import com.mana.spring.domain.JewelryType;
import com.mana.spring.domain.Product;
import com.mana.spring.dto.*;
import com.mana.spring.service.GemstoneService;
import com.mana.spring.service.JewelryTypeService;
import com.mana.spring.service.MetalService;
import com.mana.spring.service.ProductService;
import com.mana.spring.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;

@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    public GemstoneService gemstoneService;

    @Autowired
    public JewelryTypeService jewelryTypeService;

    @Autowired
    public MetalService metalService;

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

    public ProductMinimumListDTO getFilteredProducts(int pageNumber, ProductRepoFilter repoFilter) {
        int size = Pagination.getPageSize();


        ProductMinimumListDTO productMinimumListDTO = createMinimumListDTO(pageNumber, productDAO.countFiltered(repoFilter));
        Object[] results = productDAO.listFilteredProducts((pageNumber - 1) * size, size, repoFilter);
        ArrayList<ProductMinimumDTO> arrayList = new ArrayList<>();
        for (Object result : results) {
            Object[] obj = (Object[]) result;
            ProductMinimumDTO productMinimumDTO = new ProductMinimumDTO();
            BigInteger val = (BigInteger) obj[0];
            productMinimumDTO.setProductId(val.longValue());
            val = (BigInteger) obj[1];
            productMinimumDTO.setJewelryTypeId(val.longValue());
            productMinimumDTO.setProductName((String) obj[2]);
            productMinimumDTO.setImage_public_id((String) obj[3]);
            arrayList.add(productMinimumDTO);
        }
        productMinimumListDTO.setProductMinimumDTOS(arrayList);
        return productMinimumListDTO;
    }

    public Product addProduct(Product product) {
        Gemstone gemstone = gemstoneService.getGemstonebyId(product.getGemstones().iterator().next().getGemstoneId());
        JewelryType jewelryType = jewelryTypeService.getJewelryTypebyId(product.getProductJewelryType().getJewelryTypeId());
        String[] typeArray = jewelryType.getJewelryTypeName().split(" ");
        String skuJT = jewelryType.getJewelryTypeName().substring(0, 4);
        if (typeArray.length > 1)
            skuJT += typeArray[1].charAt(0);
        String sku = skuJT + "-" + gemstone.getGemstoneName().substring(0, 4);
        product.setProductPublished(false);
        product = productDAO.saveProduct(product);

        sku += "-" + product.getProductId();
        sku = sku.replaceAll("\\s", "").toLowerCase();
        product.setProductSku(sku);
        updateSKU(product.getProductId(), sku);

        return product;
    }

    public void updateSKU(long id, String sku) {
        productDAO.updateSKU(id, sku);
    }

    public void updateProduct(Product updatedProduct) {
        Product productFromDb = productDAO.getProduct(updatedProduct.getProductId()); // true to keep fetch type EAGER
        productFromDb.setProductName(updatedProduct.getProductName());
        productFromDb.setProductDescription(updatedProduct.getProductDescription());
        productFromDb.setProductWeight(updatedProduct.getProductWeight());
        productFromDb.setWeightUnit(updatedProduct.getWeightUnit());
        productFromDb.setProductPrice(updatedProduct.getProductPrice());
        productFromDb.setProductCurrency(updatedProduct.getProductCurrency());
        productFromDb.setProductQuantity(updatedProduct.getProductQuantity());
        productFromDb.setProductQuantityType(updatedProduct.getProductQuantityType());
        productFromDb.setProductOnFeatured(updatedProduct.isProductOnFeatured());
        productFromDb.setProductExpense(updatedProduct.getProductExpense());
        productFromDb.setProductAcceptCoupon(updatedProduct.isProductAcceptCoupon());
        productFromDb.setProductJewelryType(updatedProduct.getProductJewelryType());
        productFromDb.setGemstones(updatedProduct.getGemstones());
        productFromDb.setMetals(updatedProduct.getMetals());
        productFromDb.setCreatedDate(null);
        productFromDb.setUpdatedDate(null);
        System.out.println(productFromDb);
        productDAO.updateProduct(productFromDb);
    }

    @Override
    public void updateProductPublish(Long productId, boolean publishFlag) {
        System.out.println("ID : " + productId + " FLag: " + publishFlag);
        productDAO.updateProductPublish(productId, publishFlag);
    }


    public ProductDTO getProduct(Long productId) {
        return ProductDTOConverter.convertToDTO(productDAO.getProduct(productId));
    }

    public Product getProductByName(String name) {
        return productDAO.getProductByName(name); // true to keep fetch type EAGER
    }

    @Override
    public ProductListDTO partialSearch(String searchWord) {
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setProducts((ArrayList<Product>) productDAO.listPartialSearch(searchWord));
        return productListDTO;
    }

    private ProductListDTO createListDTO(int pageNumber, long count) {
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setCount(count);
        productListDTO.setCurrentPageNumber(pageNumber);
        productListDTO.calculateAndSetTotalPages();

        return productListDTO;
    }

    private ProductMinimumListDTO createMinimumListDTO(int pageNumber, long count) {
        ProductMinimumListDTO productMinimumListDTO = new ProductMinimumListDTO();
        productMinimumListDTO.setCount(count);
        productMinimumListDTO.setCurrentPageNumber(pageNumber);
        productMinimumListDTO.calculateAndSetTotalPages();

        return productMinimumListDTO;
    }

}
