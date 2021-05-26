package com.daniel.doctorappbackend.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uslugi")
public class ServiceController {
    public ServiceDao serviceDao;

    public ServiceController(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @GetMapping("/wszystkie")
    public List<Service> getAllServices(){
        return serviceDao.findAll();
    }

    @GetMapping("/id/{serviceId}")
    public Optional<Service> getSetviceById(@PathVariable Long serviceId){
        return serviceDao.findById(serviceId);
    }

    @GetMapping("/specjalizacja/{specializationId}")
    public List<Service> getServicesBySpecializationId(@PathVariable Long specializationId){
        return serviceDao.findAllBySpecializationId(specializationId);
    }

}
