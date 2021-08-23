package com.daniel.doctorappbackend.visits.model.dto;

import com.daniel.doctorappbackend.medicalservice.model.dto.MedicalServiceResponse;
import com.daniel.doctorappbackend.medicalservice.service.MedicalService;
import com.daniel.doctorappbackend.user.model.dto.DoctorResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VisitWithDoctorResponse {
    private Long id;
    private Long patientId;
    private DoctorResponse doctor;
    private MedicalServiceResponse medicalService;
    private Long availabilityId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date from;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date to;
}
