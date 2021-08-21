package com.daniel.doctorappbackend.patientAppointment.controller;

import com.daniel.doctorappbackend.patientAppointment.model.dto.PatientAppointmentResponse;
import com.daniel.doctorappbackend.patientAppointment.repository.PatientAppointmentRepository;
import com.daniel.doctorappbackend.patientAppointment.model.PatientAppointmentEntity;
import com.daniel.doctorappbackend.patientAppointment.service.PatientAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class PatientAppointmentController {
    public final PatientAppointmentService patientAppointmentService;

    @GetMapping()
    public List<PatientAppointmentResponse> getAllPatientAppointments(){
        return patientAppointmentService.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public List<PatientAppointmentResponse> getPatientAppointmentsByPatientId(@PathVariable long patientId){
        return patientAppointmentService.findByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<PatientAppointmentResponse> getPatientAppointmentsByDoctorId(@PathVariable long doctorId) {
        return null;
    }

/*
    GetMapping("doctorAvailability/{}")

    @GetMapping("/id-lekarza/{doctorId}")
    public Optional<PatientAppointmentEntity> getAppointmentByDoctorId(@PathVariable long doctorId){
        return patientAppointmentRepository.findByDoctorId(doctorId);
    }

    @GetMapping("/id-pacjenta/{patientId}")
    public Optional<PatientAppointmentEntity> getAppointmentByPatientId(@PathVariable long patientId){
        return patientAppointmentRepository.findByPatientId(patientId);
    }

    @GetMapping("/id-uslugi/{serviceId}")
    public Optional<PatientAppointmentEntity> getAppointmentBySEerviceId(@PathVariable long serviceId){
        return patientAppointmentRepository.findByServiceId(serviceId);
    }

    @GetMapping("/id-dnia-wizyty/{dayId}")
    public Optional<PatientAppointmentEntity> getAppointmentByDayId(@PathVariable long dayId){
        return patientAppointmentRepository.findByDayId(dayId);
    }

    @GetMapping("/id-statusu/{statusId}")
    public Optional<PatientAppointmentEntity> getAppointmentByStatusId(@PathVariable long statusId){
        return patientAppointmentRepository.findByStatusId(statusId);
    }*/
}
