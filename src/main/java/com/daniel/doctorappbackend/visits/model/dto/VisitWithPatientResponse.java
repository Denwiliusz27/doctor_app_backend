package com.daniel.doctorappbackend.visits.model.dto;

import com.daniel.doctorappbackend.medicalservice.model.dto.MedicalServiceResponse;
import com.daniel.doctorappbackend.user.model.dto.PatientResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VisitWithPatientResponse {
    private Long id;
    private PatientResponse patient;
    private MedicalServiceResponse medicalService;
    private Date from;
    private Date to;
}
