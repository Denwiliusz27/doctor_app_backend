package com.daniel.doctorappbackend.medicalservice.controller;

import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.repository.MedicalServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/service")
public class MedicalServiceController {
    public MedicalServiceRepository medicalServiceRepository;

    public MedicalServiceController(MedicalServiceRepository medicalServiceRepository) {
        this.medicalServiceRepository = medicalServiceRepository;
    }

    @GetMapping("/wszystkie")
    public List<MedicalServiceEntity> getAllServices(){
        return medicalServiceRepository.findAll();
    }

    @GetMapping("/id/{serviceId}")
    public Optional<MedicalServiceEntity> getSetviceById(@PathVariable Long serviceId){
        return medicalServiceRepository.findById(serviceId);
    }

    @GetMapping("/specjalizacja/{specializationId}")
    public List<MedicalServiceEntity> getServicesBySpecializationId(@PathVariable Long specializationId){
        return medicalServiceRepository.findAllBySpecializationId(specializationId);
    }

}
