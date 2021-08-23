package com.daniel.doctorappbackend.visits.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class VisitResponse {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long medicalServiceId;
    private Long availabilityId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date from;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date to;
}
