package com.rdasystems.audiomanager.service;

import com.rdasystems.audiomanager.model.Product;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<Product>  findAll(int page,int size);
    Page<Product> findProducstByCategory(ProductCategory productCategory, int page, int size);
    Page<Product> findByProductName(String name);
   // List<Product> findProductsByCategoryEquals(Long category,int page,int size);
    Product findById(Long id);
    Product save(Product product);
    Page<Product> searchByDescriptionAndName(String keywords,int page,int size);
}
