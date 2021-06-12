package com.daniel.doctorappbackend.doctor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
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

    @GetMapping("/email/{emailAddress}")
    public Optional<Doctor> getDoctorByEmailAddress(@PathVariable String emailAddress){
        System.out.println(emailAddress);
        System.out.println(doctorDao.findByDoctorEmailAddress(emailAddress));
        return doctorDao.findByDoctorEmailAddress(emailAddress);
    }

    @GetMapping("/miasto/{cityId}")
    public List<Doctor> getDoctorsByCityId(@PathVariable Long cityId){
        return doctorDao.findAllByCityId(cityId);
    }

    @PostMapping("/dodaj")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        System.out.println("dostałem doktora");
        System.out.println(doctor);

        if (this.getDoctorByEmailAddress(doctor.getDoctorEmailAddress()).isPresent()){
            System.out.println("jest już taki doktor");
            return null;
        } else {
            System.out.println("nie ma takiego doktora");
            return doctorDao.save(doctor);
        }
    }
}
