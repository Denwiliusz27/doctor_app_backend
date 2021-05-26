package com.daniel.doctorappbackend.specialization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
}

