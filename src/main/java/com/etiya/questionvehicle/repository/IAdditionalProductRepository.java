package com.etiya.questionvehicle.repository;

import com.etiya.questionvehicle.model.AdditionalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdditionalProductRepository extends JpaRepository<AdditionalProduct, Integer> {
}
