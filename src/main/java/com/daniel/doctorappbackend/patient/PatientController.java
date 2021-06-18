package com.daniel.doctorappbackend.patient;

import com.daniel.doctorappbackend.doctor.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
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

    @GetMapping("pesel/{pesel}")
    public Optional<Patient> getPatientByPatientPesel(@PathVariable String pesel){
        return patientDao.findByPatientPesel(pesel);
    }

    @GetMapping("email/{email}")
    public Optional<Patient> getPatientByPatientEmailAddress(@PathVariable String email){
        return patientDao.findByPatientEmailAddress(email);
    }

    @PostMapping("/dodaj")
    public Patient addPatient(@RequestBody Patient patient){
        System.out.println("Dostałem pacjenta i dodaje:");
        System.out.println(patient);
        return this.patientDao.save(patient);
    }
}
