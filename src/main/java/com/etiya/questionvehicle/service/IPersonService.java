package com.etiya.questionvehicle.service;

import com.etiya.questionvehicle.dto.LoginRequestDTO;
import com.etiya.questionvehicle.dto.LoginResponseDTO;

public interface IPersonService {

    LoginResponseDTO checkLogin(LoginRequestDTO loginRequestDTO);
}
