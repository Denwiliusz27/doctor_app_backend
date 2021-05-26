package com.daniel.doctorappbackend.doctor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lekarz")
public class DoctorController {
    public DoctorDao doctorDao;

    public DoctorController(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @GetMapping("/wszyscy")
    public List<Doctor> getAllDoctors() {
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
}
