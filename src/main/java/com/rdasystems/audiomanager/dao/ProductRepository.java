package com.rdasystems.audiomanager.dao;

import com.rdasystems.audiomanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long>{

}
