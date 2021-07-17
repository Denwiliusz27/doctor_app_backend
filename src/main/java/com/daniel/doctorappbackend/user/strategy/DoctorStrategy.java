package com.daniel.doctorappbackend.user.strategy;

import com.daniel.doctorappbackend.doctor.DoctorEntity;
import com.daniel.doctorappbackend.doctor.DoctorRepository;
import com.daniel.doctorappbackend.patient.PatientEntity;
import com.daniel.doctorappbackend.user.UserRepository;
import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.dto.CreateDoctorRequest;
import com.daniel.doctorappbackend.user.model.dto.CreateUserRequest;
import com.daniel.doctorappbackend.user.model.dto.DoctorResponse;
import com.daniel.doctorappbackend.user.model.dto.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class DoctorStrategy implements UserStrategy<DoctorResponse>{
    private DoctorRepository doctorRepository;
    private UserRepository userRepository;

    @Override
    public DoctorResponse buildUser(String email, String password) throws UserNotFoundException {
        return this.doctorRepository.findByUserMailAndUserPassword(email, password)
                .map(this::mapToDoctorResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public <U extends CreateUserRequest> DoctorResponse createUser(U createUserRequest) throws UserExistException {
        CreateDoctorRequest request = (CreateDoctorRequest) createUserRequest;
        boolean exist = this.userRepository.existByEmail(createUserRequest.getEmail());

        if(exist){
            throw new UserExistException();
        }
        UserEntity userEntity = this.userRepository.save(
                UserEntity.builder()
                        .name(createUserRequest.getName())
                        .surname(createUserRequest.getSurname())
                        .password(createUserRequest.getPassword())
                        .email(createUserRequest.getEmail())
                        .build()
        );
        DoctorEntity doctorEntity = this.doctorRepository.save(
                DoctorEntity.builder()
                        .description(request.getDescription())
                        .address(request.getAddress())
                        .phoneNumber(request.getPhoneNumber())
                        .user(userEntity)
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
                .build();
    }
}
