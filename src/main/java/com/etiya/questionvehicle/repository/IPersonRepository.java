package com.etiya.questionvehicle.repository;

import com.etiya.questionvehicle.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

    Person findByUserName(String userName);
}
