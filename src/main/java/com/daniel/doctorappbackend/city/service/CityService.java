package com.daniel.doctorappbackend.city.service;

import com.daniel.doctorappbackend.city.repository.CityRepository;
import com.daniel.doctorappbackend.city.model.CityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public Optional<CityEntity> findById(Long id){
        return this.cityRepository.findById(id);
    }

}
