package com.rdasystems.audiomanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="inventory")
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="inventory_name")
    private String inventoryName;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;;
    @UpdateTimestamp
    @Column(name="lastupdate_at")
    private Date lastUpdate;
    @DateTimeFormat
    @Column(name="deleted_at")
    private Date deletedAt;
    @Column(name="category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory",fetch = FetchType.LAZY)
    //@JsonIgnore
    private List<Product> productSet;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "cordinate_id",nullable = false)
    private Coordinate coordinate;
}


