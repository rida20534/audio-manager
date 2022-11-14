package com.rdasystems.audiomanager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="unit_price")
    private BigDecimal unitprice;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="active")
    private boolean active;
    @Column(name="units_in_stock")
    private int unitsInStock;
    @Column(name="created_date")
    @CreationTimestamp
    private Date createdDate;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdateDate;
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;
}
