package com.rdasystems.audiomanager.service;

import com.rdasystems.audiomanager.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    List<ProductCategory> findAllCategories();
    List<ProductCategory> findBycategory(int categoryid,int page,int size);
    Optional<ProductCategory> findById(Long id);
}
