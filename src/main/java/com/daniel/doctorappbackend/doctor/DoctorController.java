package com.daniel.doctorappbackend.doctor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/lekarz")
public class DoctorController {
    public DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping("/wszyscy")
    public List<Doctor> getAllDoctors() {
        System.out.println("jestem w backendzie!");
        return doctorDao.findAll();
    }

    @GetMapping("id/{doctorId}")
    public Optional<Doctor> getDoctorById(@PathVariable Long doctorId){
        return doctorDao.findById(doctorId);
    }

    @GetMapping("/specjalizacja/{specializationId}")
    public List<Doctor> getDoctorsBySpecializationId(@PathVariable Long specializationId){
        return doctorDao.findAllBySpecializationId(specializationId);
    }
    @GetMapping("/user/{userId}")
    public Optional<Doctor> getDoctorByUserId(@PathVariable Long userId){
        return doctorDao.findByUserId(userId);
    }

    @GetMapping("/miasto/{cityId}")
    public List<Doctor> getDoctorsByCityId(@PathVariable Long cityId){
        return doctorDao.findAllByCityId(cityId);
    }

    @PostMapping("/dodaj")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorDao.save(doctor);
    }
}
