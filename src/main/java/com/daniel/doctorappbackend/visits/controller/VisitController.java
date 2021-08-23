package com.daniel.doctorappbackend.visits.controller;

import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.visits.exception.VisitNotFoundException;
import com.daniel.doctorappbackend.visits.model.dto.UpdateVisitRequest;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse2;
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

    @PutMapping()
    public VisitResponse updateVisit(@RequestBody() UpdateVisitRequest visitRequest) throws UserNotFoundException, VisitNotFoundException, MedicalServiceNotFoundException {
        return this.visitService.updateVisit(visitRequest);
    }

    @GetMapping("/id2")
    public VisitResponse2 getVisitById2(@RequestParam(name = "visitId") Long visitId) throws VisitNotFoundException {
        return this.visitService.getVisitById2(visitId);
    }

    @GetMapping("/patient2")
    public List<VisitResponse2> getVisitsByPatientId2(@RequestParam(name="patientId") Long patientId){
        return this.visitService.findByPatientId2(patientId);
    }

}
