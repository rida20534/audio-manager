package com.rdasystems.audiomanager.web;

import com.rdasystems.audiomanager.dao.ProductCategoryRepository;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filter")

public class ProductCategoryController {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @GetMapping("/categories")
    public List<ProductCategory> allCategories(){
        return  productCategoryRepository.findAll();
    }
}
