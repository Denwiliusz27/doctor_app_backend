package com.daniel.doctorappbackend.doctorServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
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

    @PostMapping("/dodaj")
    public List<DoctorServices> addDoctorServices(@RequestBody List<DoctorServices> doctorServices){
        for (DoctorServices doctorServ : doctorServices){
            doctorServicesDao.save(doctorServ);
        }
        return doctorServices;
    }
}
