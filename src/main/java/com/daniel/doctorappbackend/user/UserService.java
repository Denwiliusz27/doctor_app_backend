package com.daniel.doctorappbackend.user;

import com.daniel.doctorappbackend.user.exception.UserExistException;
import com.daniel.doctorappbackend.user.exception.UserNotFoundException;
import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.UserRole;
import com.daniel.doctorappbackend.user.model.dto.CreateUserRequest;
import com.daniel.doctorappbackend.user.model.dto.UserResponse;
import com.daniel.doctorappbackend.user.strategy.UserStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Map<UserRole, UserStrategy<? extends UserResponse>> userStrategyMap;

    public UserResponse findUser(String email, String password) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findUserByEmailAndPassword(email, password).orElseThrow(UserNotFoundException::new);
        return this.userStrategyMap.get(userEntity.getRole()).buildUser(email, password);
    }

    public <T extends CreateUserRequest> UserResponse createUser(T createUserRequest, UserRole role) throws UserExistException {
         return this.userStrategyMap.get(role).createUser(createUserRequest);
    }
}
