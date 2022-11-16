package com.rdasystems.audiomanager.service;
import com.rdasystems.audiomanager.dao.ProductRepository;
import com.rdasystems.audiomanager.model.Product;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int page, int size) {
        return productRepository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Product> findProducstByCategory(ProductCategory productCategory, int page, int size) {
        System.out.println("findProducstByCategory "+page +" size"+size+"catego"+productCategory);
        System.out.println(productRepository.findProductsByCategory(productCategory,PageRequest.of(page,size)).getTotalPages());
        return productRepository.findProductsByCategory(productCategory,PageRequest.of(page,size));
    }

    @Override
    public Page<Product> findByProductName(String name) {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> searchByDescriptionAndName(String keywords, int page, int size) {
       return productRepository.findProductsByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keywords,keywords,PageRequest.of(page,size));
    }
}
