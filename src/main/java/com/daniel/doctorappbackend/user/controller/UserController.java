package com.daniel.doctorappbackend.user.controller;

import com.daniel.doctorappbackend.city.exception.CityNotFoundException;
import com.daniel.doctorappbackend.medicalservice.exception.MedicalServiceNotFoundException;
import com.daniel.doctorappbackend.specialization.exception.SpecializationNotFoundException;
import com.daniel.doctorappbackend.user.repository.UserRepository;
import com.daniel.doctorappbackend.user.service.UserService;
import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.UserRole;
import com.daniel.doctorappbackend.user.model.dto.CreateDoctorRequest;
import com.daniel.doctorappbackend.user.model.dto.CreatePatientRequest;
import com.daniel.doctorappbackend.user.model.dto.LoginUserRequest;
import com.daniel.doctorappbackend.user.model.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor // tworzy konstruktor z polami private
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginUserRequest loginUserRequest) throws UserNotFoundException {
        return this.userService.findUser(loginUserRequest.getEmail(), loginUserRequest.getPassword());
    }

    @PostMapping("/create/patient")
    public UserResponse createPatient(@RequestBody CreatePatientRequest createPatientRequest) throws UserExistException, SpecializationNotFoundException, CityNotFoundException, MedicalServiceNotFoundException {
        return this.userService.createUser(createPatientRequest, UserRole.PATIENT);
    }

    @PostMapping("/create/doctor")
    public UserResponse createDoctor(@RequestBody CreateDoctorRequest createDoctorRequest) throws UserExistException, SpecializationNotFoundException, CityNotFoundException, MedicalServiceNotFoundException {
        return this.userService.createUser(createDoctorRequest, UserRole.DOCTOR);
    }

    @GetMapping("id/{userId}")
    public Optional<UserEntity> getUserById(@PathVariable long userId){
        return userRepository.findById(userId);
    }
}
