package com.daniel.doctorappbackend.doctor;

import com.daniel.doctorappbackend.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private String phoneNumber;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
