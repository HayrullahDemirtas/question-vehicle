package com.etiya.questionvehicle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalProductResponseDTO {
    public AdditionalProductResponseDTO(Integer count, Integer price, Integer quantity, String name, String description, String image) {
        this.count = count;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    private Integer count;
    private Integer price;
    private Integer quantity;
    private String name;
    private String description;
    private String image;
}
