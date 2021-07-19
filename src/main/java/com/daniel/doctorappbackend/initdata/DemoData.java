package com.daniel.doctorappbackend.initdata;

import com.daniel.doctorappbackend.city.model.CityEntity;
import com.daniel.doctorappbackend.city.repository.CityRepository;
import com.daniel.doctorappbackend.specialization.repository.SpecializationRepository;
import com.daniel.doctorappbackend.specialization.model.SpecializationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoData implements CommandLineRunner {
    private final SpecializationRepository specializationRepository;
    private final CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
        specializationRepository.save(SpecializationEntity.builder().name("Konsultacja stomatologiczna").build());
        specializationRepository.save(SpecializationEntity.builder().name("Leczenie próchnicy").build());
        cityRepository.save(CityEntity.builder().name("Kraków").build());
        cityRepository.save(CityEntity.builder().name("Warszawa").build());
    }
}
