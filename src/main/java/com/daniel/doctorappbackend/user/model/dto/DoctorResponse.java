package com.daniel.doctorappbackend.user.model.dto;

import com.daniel.doctorappbackend.city.model.dto.CityResponse;
import com.daniel.doctorappbackend.specialization.model.dto.SpecializationResponse;
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
    private SpecializationResponse specialization;
    private CityResponse city;
}
