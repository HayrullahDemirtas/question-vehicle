package com.etiya.questionvehicle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    public LoginResponseDTO(Integer personId, String userType, boolean loginCheck) {
        this.personId = personId;
        this.userType = userType;
        this.loginCheck = loginCheck;
    }

    private Integer personId;
    private String userType;
    private boolean loginCheck;
}
