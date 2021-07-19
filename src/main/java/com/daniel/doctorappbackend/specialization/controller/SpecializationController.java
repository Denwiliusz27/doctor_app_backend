package com.daniel.doctorappbackend.specialization.controller;

import com.daniel.doctorappbackend.specialization.repository.SpecializationRepository;
import com.daniel.doctorappbackend.specialization.model.SpecializationEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/specjalization")
public class SpecializationController {
    public SpecializationRepository specializationRepository;

    public SpecializationController(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @GetMapping("/wszystkie")
    public List<SpecializationEntity> getAllSpecializations(){
        return specializationRepository.findAll();
    }

    @GetMapping("/id/{specializationId}")
    public Optional<SpecializationEntity> getSpecializationById(@PathVariable Long specializationId){
        return specializationRepository.findById(specializationId);
    }

    @GetMapping("/nazwa/{specializationName}")
    public Optional<SpecializationEntity> getSpecializationBySpecializationName(@PathVariable String specializationName){
        return specializationRepository.findByName(specializationName);
    }
}

