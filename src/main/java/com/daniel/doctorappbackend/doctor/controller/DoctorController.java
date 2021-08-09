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
}
