package com.daniel.doctorappbackend.doctor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/lekarz")
public class DoctorController {
    public DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/wszyscy")
    public List<DoctorEntity> getAllDoctors() {
        System.out.println("jestem w backendzie!");
        return doctorRepository.findAll();
    }

    @GetMapping("id/{doctorId}")
    public Optional<DoctorEntity> getDoctorById(@PathVariable Long doctorId){
        return doctorRepository.findById(doctorId);
    }

    @GetMapping("/specjalizacja/{specializationId}")
    public List<DoctorEntity> getDoctorsBySpecializationId(@PathVariable Long specializationId){
        return doctorRepository.findAllBySpecializationId(specializationId);
    }

    @GetMapping("/email/{emailAddress}")
    public Optional<DoctorEntity> getDoctorByEmailAddress(@PathVariable String emailAddress){
        System.out.println(emailAddress);
        System.out.println(doctorRepository.findByDoctorEmailAddress(emailAddress));
        return doctorRepository.findByDoctorEmailAddress(emailAddress);
    }

    @GetMapping("/miasto/{cityId}")
    public List<DoctorEntity> getDoctorsByCityId(@PathVariable Long cityId){
        return doctorRepository.findAllByCityId(cityId);
    }

    @PostMapping("/dodaj")
    public DoctorEntity addDoctor(@RequestBody DoctorEntity doctor){
        System.out.println("dostałem doktora");
        System.out.println(doctor);

        if (this.getDoctorByEmailAddress(doctor.getDoctorEmailAddress()).isPresent()){
            System.out.println("jest już taki doktor");
            return null;
        } else {
            System.out.println("nie ma takiego doktora");
            return doctorRepository.save(doctor);
        }
    }
}
