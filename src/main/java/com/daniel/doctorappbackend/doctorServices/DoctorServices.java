package com.daniel.doctorappbackend.doctorServices;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "uslugi_lekarzy")
public class DoctorServices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_lekarza")
    private Long doctorId;

    @Column(name = "id_uslugi")
    private Long serviceId;

    @Column(name = "cena")
    private int servicePrice;

    public DoctorServices() {
        id = 0L;
        doctorId = 0L;
        serviceId = 0L;
        servicePrice = 0;
    }

    public DoctorServices(long id, long doctorId, long serviceId, int servicePrice) {
        this.id = id;
        this.doctorId = doctorId;
        this.serviceId = serviceId;
        this.servicePrice = servicePrice;
    }

    public DoctorServices(long doctorId, long serviceId, int servicePrice) {
        this.doctorId = doctorId;
        this.serviceId = serviceId;
        this.servicePrice = servicePrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", doctorId=" + doctorId +
                ", serviceId=" + serviceId +
                ", servicePrice=" + servicePrice;
    }
}
