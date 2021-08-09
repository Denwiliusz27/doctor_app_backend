package com.daniel.doctorappbackend.availabilitydoctor.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class AvailabilityDoctorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date from;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date to;
    private Long doctorId;
    private Long id;
}
