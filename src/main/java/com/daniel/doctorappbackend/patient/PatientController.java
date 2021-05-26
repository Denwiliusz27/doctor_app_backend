package com.daniel.doctorappbackend.patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacjent")
public class PatientController {
    public PatientDao patientDao;

    public PatientController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @GetMapping("/wszyscy")
    public List<Patient> getAllPatients(){
        return patientDao.findAll();
    }

    @GetMapping("id/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable Long patientId){
        return patientDao.findById(patientId);
    }

    @GetMapping("userid/{userId}")
    public Optional<Patient> getPatientByUserId(@PathVariable Long userId){
        return patientDao.findByUserId(userId);
    }
}
