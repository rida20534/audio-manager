package com.rdasystems.audiomanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Product_category")
//generate bugs when using oneToMany relationship
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    @JsonIgnore
    private List<Product> productSet;
}
