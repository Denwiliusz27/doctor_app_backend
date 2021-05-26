package com.daniel.doctorappbackend.doctorServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uslugi-lekarzy")
public class DoctorServicesController {
    public DoctorServicesDao doctorServicesDao;

    public DoctorServicesController(DoctorServicesDao doctorServicesDao) {
        this.doctorServicesDao = doctorServicesDao;
    }

    @GetMapping("/wszystkie")
    public List<DoctorServices> getAllDoctorServices(){
        return doctorServicesDao.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DoctorServices> getDoctorServiceById(@PathVariable Long id){
        return doctorServicesDao.findById(id);
    }

    @GetMapping("/id-uslugi/{serviceId}")
    public Optional<DoctorServices> getDoctorServiceByServiceId(@PathVariable Long serviceId){
        return doctorServicesDao.findAllByServiceId(serviceId);
    }

    @GetMapping("/id-lekarza/{doctorId}")
    public List<DoctorServices> getDoctorServiceByDoctorId(@PathVariable Long doctorId){
        return doctorServicesDao.findAllByDoctorId(doctorId);
    }
}
