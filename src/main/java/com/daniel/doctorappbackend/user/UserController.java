package com.daniel.doctorappbackend.user;

import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.UserRole;
import com.daniel.doctorappbackend.user.model.dto.CreatePatientRequest;
import com.daniel.doctorappbackend.user.model.dto.LoginUserRequest;
import com.daniel.doctorappbackend.user.model.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public UserResponse createPatient(@RequestBody CreatePatientRequest createPatientRequest) throws UserExistException {
        return this.userService.createUser(createPatientRequest, UserRole.PATIENT);
    }

    @GetMapping("id/{userId}")
    public Optional<UserEntity> getUserById(@PathVariable long userId){
        return userRepository.findById(userId);
    }


}
