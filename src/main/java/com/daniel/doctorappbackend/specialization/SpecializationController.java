package com.daniel.doctorappbackend.specialization;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/specjalizacje")
public class SpecializationController {
    public SpecializationDao specializationDao;

    public SpecializationController(SpecializationDao specializationDao) {
        this.specializationDao = specializationDao;
    }

    @GetMapping("/wszystkie")
    public List<Specialization> getAllSpecializations(){
        return specializationDao.findAll();
    }

    @GetMapping("/id/{specializationId}")
    public Optional<Specialization> getSpecializationById(@PathVariable Long specializationId){
        return specializationDao.findById(specializationId);
    }

    @GetMapping("/nazwa/{specializationName}")
    public Optional<Specialization> getSpecializationBySpecializationName(@PathVariable String specializationName){
        return specializationDao.findBySpecializationName(specializationName);
    }
}

