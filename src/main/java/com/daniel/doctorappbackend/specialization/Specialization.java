package com.daniel.doctorappbackend.specialization;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "specjalizacje")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_specjalizacji")
    private Long specializationId;

    @Column(name = "nazwa")
    private String specializationName;

    public Specialization() {
        specializationId = 0L;
        specializationName = "";
    }

    public Specialization(long specializationId, String specializationName) {
        this.specializationId = specializationId;
        this.specializationName = specializationName;
    }

    public Specialization(String specializationName) {
        this.specializationName = specializationName;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    @Override
    public String toString() {
        return  "specializationId=" + specializationId +
                ", specializationName='" + specializationName + '\'';
    }
}
