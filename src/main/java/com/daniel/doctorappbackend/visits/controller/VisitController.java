package com.daniel.doctorappbackend.visits.controller;

import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.visits.exception.VisitNotFoundException;
import com.daniel.doctorappbackend.visits.model.dto.UpdateVisitRequest;
import com.daniel.doctorappbackend.visits.model.dto.VisitDetails;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse;
import com.daniel.doctorappbackend.visits.model.dto.VisitWithDoctorResponse;
import com.daniel.doctorappbackend.visits.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {
    public final VisitService visitService;

    @GetMapping()
    public List<VisitResponse> getVisitsByDoctorId(@RequestParam(name="doctorId") Long doctorId){
        return this.visitService.findFreeVisits(doctorId);
    }

    @GetMapping("/patient")
    public List<VisitResponse> getVisitsByPatientId(@RequestParam(name="patientId") Long patientId){
        return this.visitService.findByPatientId(patientId);
    }

    @GetMapping("/id")
    public VisitResponse getVisitById(@RequestParam(name = "visitId") Long visitId) throws VisitNotFoundException {
        return this.visitService.getVisitById(visitId);
    }

    @GetMapping("/details/{visitId}")
    public VisitDetails getDetailsVisitById(@PathVariable(name = "visitId") Long visitId) throws VisitNotFoundException {
        return this.visitService.getDetailsVisit(visitId);
    }

    @PutMapping()
    public VisitResponse updateVisit(@RequestBody() UpdateVisitRequest visitRequest) throws UserNotFoundException, VisitNotFoundException, MedicalServiceNotFoundException {
        return this.visitService.updateVisit(visitRequest);
    }

    @GetMapping("/visitWithDoctor/id")
    public VisitWithDoctorResponse getVisitWithDoctorById(@RequestParam(name = "visitId") Long visitId) throws VisitNotFoundException {
        return this.visitService.getVisitWithDoctorById(visitId);
    }

    @GetMapping("/visitWithDoctor/patient")
    public List<VisitWithDoctorResponse> getVisitsByPatientId2(@RequestParam(name="patientId") Long patientId){
        return this.visitService.findWithDoctorByPatientId(patientId);
    }

}
