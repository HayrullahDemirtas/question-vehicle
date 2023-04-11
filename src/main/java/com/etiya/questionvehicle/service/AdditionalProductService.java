package com.etiya.questionvehicle.service;

import com.etiya.questionvehicle.dto.AdditionalProductResponseDTO;
import com.etiya.questionvehicle.model.AdditionalProduct;
import com.etiya.questionvehicle.repository.IAdditionalProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class AdditionalProductService implements IAdditionalProduct {

    @Autowired
    private IAdditionalProductRepository additionalProductRepository;

    @Override
    public List<AdditionalProductResponseDTO> getAllAdditionalProducts() {
        List<AdditionalProductResponseDTO> response = new ArrayList<>();
        List<AdditionalProduct> products = additionalProductRepository.findAll();

        // to find out how many of 1 product there are instead of showing the same product again
        for (AdditionalProduct product : products) {
            if (response.stream().anyMatch(item -> product.getName().equalsIgnoreCase(item.getName()))) {
                for (AdditionalProductResponseDTO productDTO : response) {
                    if (productDTO.getName().equalsIgnoreCase(product.getName())) {
                        productDTO.setCount(productDTO.getCount() + 1);
                        break;
                    }
                }
            } else {
                AdditionalProductResponseDTO productDTO = new AdditionalProductResponseDTO(
                        1,
                        product.getPrice(),
                        product.getQuantity(),
                        product.getName(),
                        product.getDescription(),
                        product.getImage());

                response.add(productDTO);
            }
        }

        response.sort(Comparator.comparing(AdditionalProductResponseDTO::getCount, Comparator.nullsFirst(Comparator.naturalOrder()))
                .reversed());

        return response;
    }
}
