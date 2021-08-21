package com.daniel.doctorappbackend.patientAppointment.service;

import com.daniel.doctorappbackend.availabilitydoctor.model.AvailabilityDoctorEntity;
import com.daniel.doctorappbackend.patientAppointment.model.PatientAppointmentEntity;
import com.daniel.doctorappbackend.patientAppointment.model.dto.PatientAppointmentResponse;
import com.daniel.doctorappbackend.patientAppointment.repository.PatientAppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientAppointmentService {
    private final PatientAppointmentRepository patientAppointmentRepository;

    public List<PatientAppointmentResponse> findAll(){
        return this.patientAppointmentRepository.findAll()
                .stream()
                .map(this::mapToPatientAppointmentResponse)
                .collect(Collectors.toList());
    }

    public List<PatientAppointmentResponse> findByPatientId(Long patientId) {
        return this.patientAppointmentRepository.findByPatientId(patientId)
                .stream()
                .map(this::mapToPatientAppointmentResponse)
                .collect(Collectors.toList());
    }

    public PatientAppointmentResponse mapToPatientAppointmentResponse(PatientAppointmentEntity patientAppointmentEntity) {
        return PatientAppointmentResponse.builder()
                .id(patientAppointmentEntity.getId())
                .patientId(patientAppointmentEntity.getPatient().getId())
                .from(patientAppointmentEntity.getFrom())
                .to(patientAppointmentEntity.getTo())
                .doctorAvailability(AvailabilityDoctorEntity.builder()
                        .id(patientAppointmentEntity.getDoctorAvailability().getId())
                        .doctor(patientAppointmentEntity.getDoctorAvailability().getDoctor())
                        .from(patientAppointmentEntity.getDoctorAvailability().getFrom())
                        .to(patientAppointmentEntity.getDoctorAvailability().getTo())
                        .build())
                .build();
    }
}
