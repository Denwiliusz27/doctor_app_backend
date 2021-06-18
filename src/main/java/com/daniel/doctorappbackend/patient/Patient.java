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

    @Column(name = "pesel")
    private String patientPesel;

    @Column(name = "email")
    private String patientEmailAddress;

    @Column(name = "haslo")
    private String patientPassword;

    public Patient() {
        patientId = 0L;
        patientName = "";
        patientSurname = "";
        patientPesel = "";
        patientEmailAddress = "";
        patientPassword = "";
    }

    public Patient(long patientId, String patientName, String patientSurname, long userId, String patientPesel,
                   String patientEmailAddress, String patientPassword) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientPesel = patientPesel;
        this.patientEmailAddress = patientEmailAddress;
        this.patientPassword = patientPassword;
    }

    public Patient(String patientName, String patientSurname, long userId, String patientPesel,
                   String patientEmailAddress, String patientPassword) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientPesel = patientPesel;
        this.patientEmailAddress = patientEmailAddress;
        this.patientPassword = patientPassword;
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

    public String getPatientPesel() {
        return patientPesel;
    }

    public void setPatientPesel(String pesel) {
        this.patientPesel = pesel;
    }

    public String getPatientEmailAddress() {
        return patientEmailAddress;
    }

    public void setPatientEmailAddress(String email) {
        this.patientEmailAddress = email;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String password) {
        this.patientPassword = password;
    }

    @Override
    public String toString() {
        return  "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                ", patientPesel=" + patientPesel + '\'' +
                ", patientEmailAddress=" + patientEmailAddress + '\'' +
                ", patientPassword=" + patientPassword;
    }
}
