package com.daniel.doctorappbackend.initdata;

import com.daniel.doctorappbackend.city.model.CityEntity;
import com.daniel.doctorappbackend.city.repository.CityRepository;
import com.daniel.doctorappbackend.medicalservice.model.MedicalServiceEntity;
import com.daniel.doctorappbackend.medicalservice.repository.MedicalServiceRepository;
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
    private final MedicalServiceRepository medicalServiceRepository;

    @Override
    public void run(String... args) throws Exception {
        SpecializationEntity internista = specializationRepository.save(SpecializationEntity.builder().name("internista").build());
        SpecializationEntity stomatolog = specializationRepository.save(SpecializationEntity.builder().name("stomatolog").build());
        SpecializationEntity kardiolog =specializationRepository.save(SpecializationEntity.builder().name("kardiolog").build());
        SpecializationEntity neurolog = specializationRepository.save(SpecializationEntity.builder().name("neurolog").build());
        SpecializationEntity laryngolog =specializationRepository.save(SpecializationEntity.builder().name("laryngolog").build());
        SpecializationEntity endokrynolog =specializationRepository.save(SpecializationEntity.builder().name("endokrynolog").build());
        SpecializationEntity ortopeda =specializationRepository.save(SpecializationEntity.builder().name("ortopeda").build());
        SpecializationEntity pielegniarka =specializationRepository.save(SpecializationEntity.builder().name("pielęgniarka laboratoryjna").build());
        SpecializationEntity elektroradiolog =specializationRepository.save(SpecializationEntity.builder().name("elektroradiolog").build());

        medicalServiceRepository.save(MedicalServiceEntity.builder()
                .name("konsultacja")
                .specialization(internista)
            .build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja stomatologiczna")
                .specialization(stomatolog)
                .build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("leczenie próchnicy").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("usuwanie zęba").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("leczenie kanałowe").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("odbudowa zębów").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("wybielanie zębów").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("usuwanie kamienia").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja kardiologiczna").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("EKG").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("echo serca").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("holter").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja neurologiczna").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja laryngologiczna").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("badanie słuchu").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("płukanie uszu").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("punkcja zatok").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja endokrynologiczna").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("USG tarczycy").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("konsultacja ortopedyczna").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("USG aparatu ruchu").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("iniekcja").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("podstawowe badania krwi").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("podstawowe badania moczu i kału").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("badanie poziomu hormonów z krwi").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("rezonans magnetyczny").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("badanie poziomu hormonów z krwi").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("tomografia komputerowa").build());
        medicalServiceRepository.save(MedicalServiceEntity.builder().name("RTG").build());

        cityRepository.save(CityEntity.builder().name("Kraków").build());
        cityRepository.save(CityEntity.builder().name("Warszawa").build());
        cityRepository.save(CityEntity.builder().name("Gdańsk").build());
    }
}
