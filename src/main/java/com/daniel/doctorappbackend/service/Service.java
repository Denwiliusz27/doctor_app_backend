package com.daniel.doctorappbackend.service;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "uslugi")
public class Service {  // ~~~~~~~~ usługi ~~~~~~~~ //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_uslugi")
    private Long serviceId;

    @Column(name = "nazwa")
    private String serviceName;

    @Column(name = "id_specjalizacji")
    private Long specializationId;

    @Column(name = "dlugosc_wizyty")
    private Time serviceLength;

    public Service() {
        serviceId = 0L;
        serviceName = "";
        specializationId = 0L;
        serviceLength = new Time(0,0,0);
    }

    public Service(long serviceId, String serviceName, long specializationId, Time serviceLength) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.specializationId = specializationId;
        this.serviceLength = serviceLength;
    }

    public Service(String serviceName, long specializationId, Time serviceLength) {
        this.serviceName = serviceName;
        this.specializationId = specializationId;
        this.serviceLength = serviceLength;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public Time getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(Time serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Override
    public String toString() {
        return  "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", specializationId=" + specializationId +
                ", serviceLength=" + serviceLength;
    }
}
