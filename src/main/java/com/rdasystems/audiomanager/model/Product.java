package com.rdasystems.audiomanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data @NoArgsConstructor @AllArgsConstructor
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
    private Integer unitsInStock;
    @Column(name="created_date")
    @CreationTimestamp
    private Date createdDate;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdateDate;
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;
 /*   @ManyToOne
    @JsonIgnore
    @JoinColumn(name="inventory_id",nullable = false)
    private Inventory inventory;*/

}
