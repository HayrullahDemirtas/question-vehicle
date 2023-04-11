package com.etiya.questionvehicle.repository;

import com.etiya.questionvehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findAllByPersonId(Integer personId);
}
