package com.etiya.questionvehicle.controller;

import com.etiya.questionvehicle.dto.VehicleResponseDTO;
import com.etiya.questionvehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    // For Use Case 2
    @CrossOrigin
    @GetMapping(path = "/allVehicles")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles(){
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }

    // For Use Case 1
    @CrossOrigin
    @GetMapping(path = "/vehicles")
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehiclesByPersonId(@RequestParam("personId") Integer personId){
        List<VehicleResponseDTO> vehicles = vehicleService.getAllVehiclesByPersonId(personId);
        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
}
