package com.etiya.questionvehicle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "additional_product")
public class AdditionalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;

    @Column(nullable = false, name = "vehicle_id")
    private Integer vehicleId;

    @Column(nullable = false, name = "price")
    private Integer price;

    @Column(nullable = false, name = "quantity")
    private Integer quantity;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "image")
    private String image;
}
