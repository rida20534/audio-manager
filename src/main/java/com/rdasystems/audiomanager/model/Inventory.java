package com.rdasystems.audiomanager.model;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="inventory")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name="inventory_name")
    private String inventoryName;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name="lastupdate_at")
    private LocalDateTime lastUpdate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date deletedAt;
    //@JsonIgnore
   //  @OneToMany
   // private List<Product> productSet;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinate_id",nullable = false)
    private Coordinate coordinate;
}
