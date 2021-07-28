package com.daniel.doctorappbackend.user.repository;

import com.daniel.doctorappbackend.user.model.UserEntity;
import com.daniel.doctorappbackend.user.model.dto.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmailAndPassword(String email, String password);

    boolean existsUserEntityByEmail(String email);

    Optional<UserEntity> findUserByEmail(String email);
}
