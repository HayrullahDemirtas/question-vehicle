package com.etiya.questionvehicle.service;

import com.etiya.questionvehicle.dto.VehicleResponseDTO;
import java.util.List;
public interface IVehicleService {
    List<VehicleResponseDTO> getAllVehicles();
    List<VehicleResponseDTO> getAllVehiclesByPersonId(Integer personId);
}
