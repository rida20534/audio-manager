package com.rdasystems.audiomanager.dao;
import com.rdasystems.audiomanager.model.Product;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository <Product,Long> {
    public Page<Product> findProductsByCategory(ProductCategory category, Pageable pageable);
    public Page<Product> findProductsByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String keywords1,String keywords2,Pageable pageable);
}
