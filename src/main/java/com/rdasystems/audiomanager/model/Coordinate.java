package com.rdasystems.audiomanager.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data //@NoArgsConstructor
//@AllArgsConstructor
public class Coordinate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "country",length = 25)
    private String country;
    @Column(name = "ville",length = 25)
    private String ville;
    @Column(name = "address",length = 100)
    private String adress;
    @Column(name = "zipcode",length = 20)
    private String zipCode;
    private Double logitude;
    private Double latitude;

}
