package com.daniel.doctorappbackend.patient;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/pacjent")
public class PatientController {
    public PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/wszyscy")
    public List<PatientEntity> getAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("id/{patientId}")
    public Optional<PatientEntity> getPatientById(@PathVariable Long patientId){
        return patientRepository.findById(patientId);
    }

   /* @GetMapping("pesel/{pesel}")
    public Optional<PatientEntity> getPatientByPatientPesel(@PathVariable String pesel){
        return patientRepository.findByPatientPesel(pesel);
    }

    @GetMapping("email/{email}")
    public Optional<PatientEntity> getPatientByPatientEmailAddress(@PathVariable String email){
        return patientRepository.findByPatientEmailAddress(email);
    }*/

    @PostMapping("/dodaj")
    public PatientEntity addPatient(@RequestBody PatientEntity patientEntity){
        System.out.println("Dostałem pacjenta i dodaje:");
        System.out.println(patientEntity);
        return this.patientRepository.save(patientEntity);
    }
}
