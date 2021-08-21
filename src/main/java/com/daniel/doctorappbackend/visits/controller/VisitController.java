package com.daniel.doctorappbackend.visits.controller;

import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.visits.exception.VisitNotFoundException;
import com.daniel.doctorappbackend.visits.model.dto.UpdateVisitRequest;
import com.daniel.doctorappbackend.visits.model.dto.VisitResponse;
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

    @PutMapping()
    public VisitResponse updateVisit(@RequestBody() UpdateVisitRequest visitRequest) throws UserNotFoundException, VisitNotFoundException, MedicalServiceNotFoundException {
        return this.visitService.updateVisit(visitRequest);
    }
}
