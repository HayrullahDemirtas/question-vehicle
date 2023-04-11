package com.etiya.questionvehicle.dto;

import com.etiya.questionvehicle.model.AdditionalProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VehicleResponseDTO {
    public VehicleResponseDTO(String userName, Integer price, Integer year, Integer km, String brand, String model, String caseType, String fuel, String gear, String engine, String packageName, String image, String color, List<AdditionalProduct> additionalProducts) {
        this.userName = userName;
        this.price = price;
        this.year = year;
        this.km = km;
        this.brand = brand;
        this.model = model;
        this.caseType = caseType;
        this.fuel = fuel;
        this.gear = gear;
        this.engine = engine;
        this.packageName = packageName;
        this.image = image;
        this.color = color;
        this.additionalProducts = additionalProducts;
    }

    private String userName;
    private Integer price;
    private Integer year;
    private Integer km;
    private String brand;
    private String model;
    private String caseType;
    private String fuel;
    private String gear;
    private String engine;
    private String packageName;
    private String image;
    private String color;
    private List<AdditionalProduct> additionalProducts = new ArrayList<>();
}
