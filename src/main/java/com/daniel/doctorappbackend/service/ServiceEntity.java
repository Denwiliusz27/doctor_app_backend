package com.daniel.doctorappbackend.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "uslugi")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceEntity {  // ~~~~~~~~ usługi ~~~~~~~~ //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long specializationId;
    private Time length;
}
