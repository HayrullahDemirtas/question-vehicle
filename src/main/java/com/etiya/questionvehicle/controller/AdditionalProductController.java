package com.etiya.questionvehicle.controller;

import com.etiya.questionvehicle.dto.AdditionalProductResponseDTO;
import com.etiya.questionvehicle.service.IAdditionalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdditionalProductController {

    @Autowired
    private IAdditionalProduct additionalProduct;

    // For Use Case 3
    @CrossOrigin
    @GetMapping(path = "/allAdditionalProducts")
    public ResponseEntity<List<AdditionalProductResponseDTO>> getAllAdditionalProduct(){
        List<AdditionalProductResponseDTO> additionalProducts = additionalProduct.getAllAdditionalProducts();
        return new ResponseEntity<>(additionalProducts,HttpStatus.OK);
    }
}
