package com.daniel.doctorappbackend.doctorServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/uslugi-lekarzy")
public class DoctorServicesController {
    public DoctorServicesRepository doctorServicesRepository;

    public DoctorServicesController(DoctorServicesRepository doctorServicesRepository) {
        this.doctorServicesRepository = doctorServicesRepository;
    }

    @GetMapping("/wszystkie")
    public List<DoctorServiceEntity> getAllDoctorServices(){
        return doctorServicesRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DoctorServiceEntity> getDoctorServiceById(@PathVariable Long id){
        return doctorServicesRepository.findById(id);
    }

    @GetMapping("/id-uslugi/{serviceId}")
    public Optional<DoctorServiceEntity> getDoctorServiceByServiceId(@PathVariable Long serviceId){
        return doctorServicesRepository.findAllByServiceId(serviceId);
    }

    @GetMapping("/id-lekarza/{doctorId}")
    public List<DoctorServiceEntity> getDoctorServiceByDoctorId(@PathVariable Long doctorId){
        return doctorServicesRepository.findAllByDoctorId(doctorId);
    }

    @PostMapping("/dodaj")
    public List<DoctorServiceEntity> addDoctorServices(@RequestBody List<DoctorServiceEntity> doctorServices){
        for (DoctorServiceEntity doctorServ : doctorServices){
            doctorServicesRepository.save(doctorServ);
        }
        return doctorServices;
    }
}
