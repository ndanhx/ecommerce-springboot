package com.ecommerce.library.service;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    Product save(MultipartFile imageProduct, ProductDto productDto);

    Product update(MultipartFile imageProduct, ProductDto productDto);

    void deletedById(Long id);

    void enableById(Long id);

    ProductDto getById(Long id);

    Product findById(Long id);

    Page<ProductDto> pageProducts(int pageNo);

    Page<ProductDto> searchProducts(int pageNo, String keyword);


    /*CUSTOMER */
    List<Product> getAllProducts();

    List<Product> listViewProducts();

    List<Product> getRelatedProducts(Long categoryId);

    List<Product> getProductByCategory(Long categoryId);

    List<Product> filterHighPrice();

    List<Product> filterLowerPrice();


}
