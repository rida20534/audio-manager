package com.rdasystems.audiomanager.dao;
import com.rdasystems.audiomanager.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
