package com.daniel.doctorappbackend.service;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/uslugi")
public class ServiceController {
    public ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/wszystkie")
    public List<ServiceEntity> getAllServices(){
        return serviceRepository.findAll();
    }

    @GetMapping("/id/{serviceId}")
    public Optional<ServiceEntity> getSetviceById(@PathVariable Long serviceId){
        return serviceRepository.findById(serviceId);
    }

    @GetMapping("/specjalizacja/{specializationId}")
    public List<ServiceEntity> getServicesBySpecializationId(@PathVariable Long specializationId){
        return serviceRepository.findAllBySpecializationId(specializationId);
    }

}
