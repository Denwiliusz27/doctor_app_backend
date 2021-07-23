package com.daniel.doctorappbackend.user.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CityResponse {
    private Long id;
    private String name;
}
