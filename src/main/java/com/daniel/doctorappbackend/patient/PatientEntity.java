package com.daniel.doctorappbackend.patient;

import com.daniel.doctorappbackend.user.model.UserEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patients")
@Builder
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pesel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
