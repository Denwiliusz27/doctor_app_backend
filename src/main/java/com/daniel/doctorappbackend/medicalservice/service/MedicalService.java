package com.daniel.doctorappbackend.medicalservice.service;

import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.repository.MedicalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalService {
    private final MedicalServiceRepository medicalServiceRepository;

    public Optional<MedicalServiceEntity> findById(Long id){
        return this.medicalServiceRepository.findById(id);
    }
}
