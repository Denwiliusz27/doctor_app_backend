package com.daniel.doctorappbackend.user.strategy;

import com.daniel.doctorappbackend.city.exception.CityNotFoundException;
import com.daniel.doctorappbackend.city.model.CityEntity;
import com.daniel.doctorappbackend.city.model.dto.CityResponse;
import com.daniel.doctorappbackend.city.service.CityService;
import com.daniel.doctorappbackend.doctor.DoctorEntity;
import com.daniel.doctorappbackend.doctor.DoctorRepository;
import com.daniel.doctorappbackend.specialization.exception.SpecializationNotFoundException;
import com.daniel.doctorappbackend.specialization.model.SpecializationEntity;
import com.daniel.doctorappbackend.specialization.model.dto.SpecializationResponse;
import com.daniel.doctorappbackend.specialization.service.SpecializationService;
import com.daniel.doctorappbackend.user.repository.UserRepository;
import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.UserRole;
import com.daniel.doctorappbackend.user.model.dto.CreateDoctorRequest;
import com.daniel.doctorappbackend.user.model.dto.CreateUserRequest;
import com.daniel.doctorappbackend.user.model.dto.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorStrategy implements UserStrategy<DoctorResponse>{
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final SpecializationService specializationService;
    private final CityService cityService;

    @Override
    public DoctorResponse buildUser(String email, String password) throws UserNotFoundException {
        return this.doctorRepository.findByUserEmailAndUserPassword(email, password)
                .map(this::mapToDoctorResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public <U extends CreateUserRequest> DoctorResponse createUser(U createUserRequest) throws UserExistException, SpecializationNotFoundException, CityNotFoundException {
        CreateDoctorRequest request = (CreateDoctorRequest) createUserRequest;
        boolean exist = this.userRepository.existsUserEntityByEmail(createUserRequest.getEmail());

        if(exist){
            throw new UserExistException();
        }

        SpecializationEntity specializationEntity = this.specializationService.findById(request.getSpecializationId())
                .orElseThrow(() -> new SpecializationNotFoundException(request.getSpecializationId()));

        CityEntity cityEntity = this.cityService.findById(request.getCityId())
                .orElseThrow(() -> new CityNotFoundException(request.getCityId()));
        UserEntity userEntity = this.userRepository.save(
                UserEntity.builder()
                        .name(createUserRequest.getName())
                        .surname(createUserRequest.getSurname())
                        .password(createUserRequest.getPassword())
                        .email(createUserRequest.getEmail())
                        .role(UserRole.DOCTOR)
                        .build()
        );

        DoctorEntity doctorEntity = this.doctorRepository.save(
                DoctorEntity.builder()
                        .description(request.getDescription())
                        .address(request.getAddress())
                        .phoneNumber(request.getPhoneNumber())
                        .user(userEntity)
                        .specialization(specializationEntity)
                        .city(cityEntity)
                        .build()
        );
        return this.mapToDoctorResponse(doctorEntity);
    }

    private DoctorResponse mapToDoctorResponse(DoctorEntity doctorEntity) {
        return DoctorResponse.builder()
                .name(doctorEntity.getUser().getName())
                .surname(doctorEntity.getUser().getSurname())
                .email(doctorEntity.getUser().getEmail())
                .userId(doctorEntity.getUser().getId())
                .id(doctorEntity.getId())
                .description(doctorEntity.getDescription())
                .phoneNumber(doctorEntity.getPhoneNumber())
                .address(doctorEntity.getAddress())
                .userRole(doctorEntity.getUser().getRole())
                .specialization(
                        SpecializationResponse.builder()
                        .id(doctorEntity.getSpecialization().getId())
                        .name(doctorEntity.getSpecialization().getName())
                        .build()
                )
                .city(
                        CityResponse.builder()
                                .id(doctorEntity.getCity().getId())
                                .name(doctorEntity.getCity().getName())
                                .build()
                )
                .build();
    }
}
