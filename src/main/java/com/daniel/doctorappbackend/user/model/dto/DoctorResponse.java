package com.daniel.doctorappbackend.user.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DoctorResponse extends UserResponse {
    private String address;
    private String phoneNumber;
    private String description;
}
