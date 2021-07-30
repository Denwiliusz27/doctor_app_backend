package com.daniel.doctorappbackend.doctor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/doctors")
public class DoctorController {
    public DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping()
    public List<DoctorEntity> getAllDoctors() {
        System.out.println("jestem w backendzie!");
        return doctorRepository.findAll();
    }

    @GetMapping("id/{doctorId}")
    public Optional<DoctorEntity> getDoctorById(@PathVariable Long doctorId){
        return doctorRepository.findById(doctorId);
    }

    @GetMapping("/email/{emailAddress}")
    public Optional<DoctorEntity> getDoctorByEmailAddress(@PathVariable String emailAddress){
        System.out.println(emailAddress);
        System.out.println(doctorRepository.findByUserEmail(emailAddress));
        return doctorRepository.findByUserEmail(emailAddress);
    }
 /*
    @GetMapping("/specjalizacja/{specializationId}")
    public List<DoctorEntity> getDoctorsBySpecializationId(@PathVariable Long specializationId){
        return doctorRepository.findAllBySpecializationId(specializationId);
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
    }*/
}
