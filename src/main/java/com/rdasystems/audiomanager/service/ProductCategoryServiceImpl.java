package com.rdasystems.audiomanager.service;
import com.rdasystems.audiomanager.dao.ProductCategoryRepository;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findAllCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findBycategory(int categoryid, int page, int size) {
        return null;
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return productCategoryRepository.findById(id);
    }
}
