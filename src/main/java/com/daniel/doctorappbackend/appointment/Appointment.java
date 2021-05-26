package com.daniel.doctorappbackend.appointment;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "wizyty")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_wizyty")
    private Long appointmentId;

    @Column(name = "id_lekarza")
    private Long doctorId;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "id_uslugi")
    private Long serviceId;

    @Column(name = "id_dnia_wizyty")
    private Long dayId;

    @Column(name = "godzina_rozpoczecia")
    private Time startHour;

    @Column(name = "id_statusu")
    private Long statusId;

    public Appointment() {
        appointmentId = 0L;
        doctorId = 0L;
        patientId = 0L;
        serviceId = 0L;
        dayId = 0L;
        startHour = new Time(0, 0, 0);
    }

    public Appointment(long appointmentId, long doctorId, long patientId, long serviceId, long dayId, Time startHour, long statusId) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.serviceId = serviceId;
        this.dayId = dayId;
        this.startHour = startHour;
        this.statusId = statusId;
    }

    public Appointment(long doctorId, long patientId, long serviceId, long dayId, Time startHour, long statusId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.serviceId = serviceId;
        this.dayId = dayId;
        this.startHour = startHour;
        this.statusId = statusId;
    }

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return  "appointmentId=" + appointmentId +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", serviceId=" + serviceId +
                ", dayId=" + dayId +
                ", startHour=" + startHour +
                ", statusId=" + statusId;
    }
}
