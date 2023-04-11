package com.etiya.questionvehicle.controller;

import com.etiya.questionvehicle.dto.LoginRequestDTO;
import com.etiya.questionvehicle.dto.LoginResponseDTO;
import com.etiya.questionvehicle.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private IPersonService personService;

    // For Login
    @CrossOrigin
    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponseDTO> checkLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO person = personService.checkLogin(loginRequestDTO);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }
}
