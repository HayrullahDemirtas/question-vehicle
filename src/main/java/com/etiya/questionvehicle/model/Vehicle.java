package com.etiya.questionvehicle.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    @Column(nullable = false, name = "person_id")
    private Integer personId;

    @Column(nullable = false, name = "price")
    private Integer price;

    @Column(nullable = false, name = "year")
    private Integer year;

    @Column(nullable = false, name = "km")
    private Integer km;

    @Column(nullable = false, name = "brand")
    private String brand;

    @Column(nullable = false, name = "model")
    private String model;

    @Column(nullable = false, name = "case_type")
    private String caseType;

    @Column(nullable = false, name = "fuel")
    private String fuel;

    @Column(nullable = false, name = "gear")
    private String gear;

    @Column(nullable = false, name = "engine")
    private String engine;

    @Column(nullable = false, name = "package_name")
    private String packageName;

    @Column(nullable = false, name = "image")
    private String image;

    @Column(nullable = false, name = "color")
    private String color;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "vehicle_id")
    private List<AdditionalProduct> additionalProducts = new ArrayList<>();
}
