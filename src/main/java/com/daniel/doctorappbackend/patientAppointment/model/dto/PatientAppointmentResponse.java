package com.daniel.doctorappbackend.patientAppointment.model.dto;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PatientAppointmentResponse {
    private Long id;
    private Long patientId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date from;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date to;
    private AvailabilityDoctorEntity doctorAvailability;
    private MedicalServiceEntity service;
}
