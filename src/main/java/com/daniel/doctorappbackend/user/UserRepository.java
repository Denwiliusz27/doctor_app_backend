package com.daniel.doctorappbackend.user;

import com.daniel.doctorappbackend.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmailAndPassword(String email, String password);

    boolean existByEmail(String email);
}
