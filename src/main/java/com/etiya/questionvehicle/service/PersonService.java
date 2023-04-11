package com.etiya.questionvehicle.service;

import com.etiya.questionvehicle.dto.LoginRequestDTO;
import com.etiya.questionvehicle.dto.LoginResponseDTO;
import com.etiya.questionvehicle.model.Person;
import com.etiya.questionvehicle.repository.IPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public LoginResponseDTO checkLogin(LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(null, null, false);
        Optional<Person> person = Optional.ofNullable(personRepository.findByUserName(loginRequestDTO.getUserName()));

        if (person.isPresent() && person.get().getPassword().equals(loginRequestDTO.getPassword())) {
            loginResponseDTO.setPersonId(person.get().getPersonId());
            loginResponseDTO.setUserType(person.get().getUserType());
            loginResponseDTO.setLoginCheck(true);
        }

        return loginResponseDTO;
    }
}
