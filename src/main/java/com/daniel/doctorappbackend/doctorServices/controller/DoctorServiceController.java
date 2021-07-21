package com.daniel.doctorappbackend.doctorServices.controller;

import com.daniel.doctorappbackend.doctorServices.repository.DoctorServiceRepository;
import com.daniel.doctorappbackend.doctorServices.model.DoctorServiceEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/uslugi-lekarzy")
public class DoctorServiceController {
    public DoctorServiceRepository doctorServiceRepository;

    public DoctorServiceController(DoctorServiceRepository doctorServiceRepository) {
        this.doctorServiceRepository = doctorServiceRepository;
    }

    @GetMapping("/wszystkie")
    public List<DoctorServiceEntity> getAllDoctorServices(){
        return doctorServiceRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DoctorServiceEntity> getDoctorServiceById(@PathVariable Long id){
        return doctorServiceRepository.findById(id);
    }

    @GetMapping("/id-uslugi/{serviceId}")
    public Optional<DoctorServiceEntity> getDoctorServiceByServiceId(@PathVariable Long serviceId){
        return doctorServiceRepository.findAllByServiceId(serviceId);
    }

    @GetMapping("/id-lekarza/{doctorId}")
    public List<DoctorServiceEntity> getDoctorServiceByDoctorId(@PathVariable Long doctorId){
        return doctorServiceRepository.findAllByDoctorId(doctorId);
    }

    @PostMapping("/dodaj")
    public List<DoctorServiceEntity> addDoctorServices(@RequestBody List<DoctorServiceEntity> doctorServices){
        for (DoctorServiceEntity doctorServ : doctorServices){
            doctorServiceRepository.save(doctorServ);
        }
        return doctorServices;
    }
}
