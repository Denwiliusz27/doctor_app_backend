package com.daniel.doctorappbackend.doctor.controller;

import com.daniel.doctorappbackend.user.model.dto.DoctorResponse;
import com.daniel.doctorappbackend.user.strategy.DoctorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorStrategy doctorStrategy;

    @GetMapping()
    public List<DoctorResponse> findDoctorsByCityAndSpecialization(@RequestParam(name = "cityId") Long cityId,
                                                                   @RequestParam(name = "specializationId") Long specializationId ){
        return doctorStrategy.findDoctorByCityAndSpecialization(cityId, specializationId);
    }

    @GetMapping("/all")
    public List<DoctorResponse> findAllDoctors(){
        return doctorStrategy.findAll();
    }

    @GetMapping("/city")
    public List<DoctorResponse> findDoctorsByCity(@RequestParam(name = "cityId") Long cityId){
        return doctorStrategy.findDoctorByCity(cityId);
    }

    @GetMapping("/specialization")
    public List<DoctorResponse> findDoctorsBySpecialization(@RequestParam(name = "specializationId") Long specializationId){
        return doctorStrategy.findDoctorBySpecialization(specializationId);
    }
}
