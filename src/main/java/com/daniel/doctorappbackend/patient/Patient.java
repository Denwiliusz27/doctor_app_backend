package com.daniel.doctorappbackend.patient;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pacjenci")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "imie")
    private String patientName;

    @Column(name = "nazwisko")
    private String patientSurname;

    @Column(name = "id_uzytkownika")
    private Long userId;

    public Patient() {
        patientId = 0L;
        patientName = "";
        patientSurname = "";
        userId = 0L;
    }

    public Patient(long patientId, String patientName, String patientSurname, long userId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.userId = userId;
    }

    public Patient(String patientName, String patientSurname, long userId) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.userId = userId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return  "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                ", userId=" + userId;
    }
}
