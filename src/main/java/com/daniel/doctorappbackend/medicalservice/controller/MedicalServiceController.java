package com.daniel.doctorappbackend.medicalservice.controller;

import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.model.dto.MedicalServiceResponse;
import com.daniel.doctorappbackend.medicalservice.repository.MedicalServiceRepository;
import com.daniel.doctorappbackend.medicalservice.service.MedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/medical-services")
@RequiredArgsConstructor
public class MedicalServiceController {
    private final MedicalService medicalService;

    @GetMapping()
    public List<MedicalServiceResponse> getAllServices(){
        return medicalService.findAll();
    }

    @GetMapping("/specialization/{specializationId}")
    public List<MedicalServiceResponse> findBySpecializationID(@PathVariable Long specializationId){
        return medicalService.findBySpecializationId(specializationId);
    }
/*
    @GetMapping("/specjalizacja/{specializationId}")
    public List<MedicalServiceEntity> getServicesBySpecializationId(@PathVariable Long specializationId){
        return medicalServiceRepository.findAllBySpecializationId(specializationId);
    }*/

}
