package com.daniel.doctorappbackend.city.controller;

import com.daniel.doctorappbackend.city.exception.CityNotFoundException;
import com.daniel.doctorappbackend.city.model.CityEntity;
import com.daniel.doctorappbackend.city.repository.CityRepository;
import com.daniel.doctorappbackend.city.service.CityService;
import com.daniel.doctorappbackend.user.model.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// dodanie (postMapping) nowego miasta /miasta/dodaj/{NazwaMiasta}

@CrossOrigin("http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")  // localhost:8080/miasta
public class CityController {
    private CityRepository cityRepository;
    private CityService cityService;

    @GetMapping("get/{cityId}")
    public CityResponse getCityById(@PathVariable long cityId) throws CityNotFoundException {
        return this.cityService.findById(cityId);
    }

    @GetMapping("getAll")
    public List<CityResponse> getAllCities(){
        return this.cityService.findAll();
    }
}
