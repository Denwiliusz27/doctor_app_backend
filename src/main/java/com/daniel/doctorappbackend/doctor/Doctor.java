package com.daniel.doctorappbackend.doctor;

import lombok.Data;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
@Table(name = "lekarze")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lekarza")
    private Long doctorId;

    @Column(name = "imie")
    private String doctorName;

    @Column(name = "nazwisko")
    private String doctorSurname;

    @Column(name = "email")
    private String doctorEmailAddress;

    @Column(name = "haslo")
    private String doctorPassword;

    @Column(name = "id_specjalizacji")
    private Long specializationId;

    @Column(name = "id_miasta")
    private Long cityId;

    @Column(name = "adres")
    private String doctorAddress;

    @Column(name = "telefon")
    private String phoneNr;

    @Column(name = "opis")
    private String description;

    @Column(name = "zdjecie")
    private transient MultipartFile doctorPicture;  // ???


    public Doctor() {
        doctorId = 0L;
        doctorName = "";
        doctorSurname = "";
        doctorEmailAddress = "";
        doctorPassword = "";
        specializationId = 0L;
        cityId = 0L;
        doctorAddress = "";
        phoneNr = "";
        description = "";
        doctorPicture = null;
    }

    public Doctor(long doctorId, String name, String surname, String email, String password, long specializationId,
                  long cityId, String address, String phoneNr, String description, MultipartFile picture) {
        this.doctorId = doctorId;
        this.doctorName = name;
        this.doctorSurname = surname;
        this.doctorEmailAddress = email;
        this.doctorPassword = password;
        this.specializationId = specializationId;
        this.cityId = cityId;
        this.doctorAddress = address;
        this.phoneNr = phoneNr;
        this.description = description;
        this.doctorPicture = picture;
    }

    public Doctor(String name, String surname, String email, String password, long specializationId, long cityId,
                  String address, String phoneNr, String description, MultipartFile picture) {
        this.doctorName = name;
        this.doctorSurname = surname;
        this.doctorEmailAddress = email;
        this.doctorPassword = password;
        this.specializationId = specializationId;
        this.cityId = cityId;
        this.doctorAddress = address;
        this.phoneNr = phoneNr;
        this.description = description;
        this.doctorPicture = picture;
    }


    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String name) {
        this.doctorName = name;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public String getDoctorEmailAddress(){
        return doctorEmailAddress;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorSurname(String surname) {
        this.doctorSurname = surname;
    }

    public void setDoctorEmailAddress(String emailAddress) {
        this.doctorEmailAddress = emailAddress;
    }

    public void setDoctorPassword(String password){
        this.doctorPassword = password;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String address) {
        this.doctorAddress = address;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getDoctorPicture() {
        return doctorPicture;
    }

    public void setDoctorPicture(MultipartFile picture) {
        this.doctorPicture = picture;
    }

    @Override
    public String toString() {
        return  "doctorId=" + doctorId +
                ", name='" + doctorName + '\'' +
                ", surname='" + doctorSurname + '\'' +
                ", emailAddress='" + doctorEmailAddress + '\'' +
                ", password='" + doctorPassword + '\'' +
                ", specializationId=" + specializationId +
                ", cityId=" + cityId +
                ", address='" + doctorAddress + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", description='" + description + '\'' +
                ", picture=" + doctorPicture;
    }
}
