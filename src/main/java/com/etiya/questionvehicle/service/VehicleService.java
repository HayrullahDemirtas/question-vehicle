package com.etiya.questionvehicle.service;

import com.etiya.questionvehicle.dto.VehicleResponseDTO;
import com.etiya.questionvehicle.model.Person;
import com.etiya.questionvehicle.model.Vehicle;
import com.etiya.questionvehicle.repository.IPersonRepository;
import com.etiya.questionvehicle.repository.IVehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<VehicleResponseDTO> getAllVehiclesByPersonId(Integer personId) {
        List<VehicleResponseDTO> response = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAllByPersonId(personId);

        for (Vehicle vehicle : vehicles) {
            Optional<Person> person = personRepository.findById(vehicle.getPersonId());
            if (person.isPresent()) {
                VehicleResponseDTO vehicleDTO = new VehicleResponseDTO(
                        person.get().getUserName(),
                        vehicle.getPrice(),
                        vehicle.getYear(),
                        vehicle.getKm(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getCaseType(),
                        vehicle.getFuel(),
                        vehicle.getGear(),
                        vehicle.getEngine(),
                        vehicle.getPackageName(),
                        vehicle.getImage(),
                        vehicle.getColor(),
                        vehicle.getAdditionalProducts());

                response.add(vehicleDTO);
            }
        }

        return response;
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        List<VehicleResponseDTO> response = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll();

        for (Vehicle vehicle : vehicles) {
            Optional<Person> person = personRepository.findById(vehicle.getPersonId());
            if (person.isPresent()) {
                VehicleResponseDTO vehicleDTO = new VehicleResponseDTO(
                        person.get().getUserName(),
                        vehicle.getPrice(),
                        vehicle.getYear(),
                        vehicle.getKm(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getCaseType(),
                        vehicle.getFuel(),
                        vehicle.getGear(),
                        vehicle.getEngine(),
                        vehicle.getPackageName(),
                        vehicle.getImage(),
                        vehicle.getColor(),
                        vehicle.getAdditionalProducts());

                response.add(vehicleDTO);
            }
        }

        return response;
    }
}
