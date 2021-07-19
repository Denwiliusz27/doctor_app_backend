package com.daniel.doctorappbackend.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // gettery i settery
@Entity
@Table(name = "users")
@NoArgsConstructor // public User() {}
@AllArgsConstructor  // public User(args)
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole role;
}

