package com.daniel.doctorappbackend.user;

import com.daniel.doctorappbackend.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmailAndPassword(String email, String password);

    boolean existByEmail(String email);
}
