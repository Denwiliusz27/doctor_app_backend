package com.daniel.doctorappbackend.availabilitydoctor.controller;

import com.daniel.doctorappbackend.availabilitydoctor.model.dto.AvailabilityDoctorResponse;
import com.daniel.doctorappbackend.availabilitydoctor.model.dto.CreateAvailabilityDoctorRequest;
import com.daniel.doctorappbackend.availabilitydoctor.service.AvailabilityDoctorService;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/availabilities-doctor")
@RequiredArgsConstructor
public class AvailabilityDoctorController {
    private final AvailabilityDoctorService availabilityDoctorService;

    /*
    Funkcja odbierająca żądanie GET, w celu pobrania dostępności lekarza o podanym id
    */
    @GetMapping()
    public List<AvailabilityDoctorResponse> findById(@RequestParam(name = "doctorId") Long doctorId) {
        return this.availabilityDoctorService.findByDoctorId(doctorId);
    }

    /*
    Funkcja odbierająca żądanie POST, w celu dodania dostępności lekarza o podanym id do bazy
    */
    @PostMapping
    public AvailabilityDoctorResponse add(@RequestBody CreateAvailabilityDoctorRequest request) throws UserNotFoundException {
        return this.availabilityDoctorService.add(request);
    }

    /*
    Funkcja odbierająca żądanie DELETE, w celu usunięcia dostępności o podanym id
    */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        this.availabilityDoctorService.delete(id);
    }
}
