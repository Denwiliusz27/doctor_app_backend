package com.daniel.doctorappbackend.user.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateDoctorRequest extends CreateUserRequest{
    private String description;
    private String phoneNumber;
    private String address;
}
