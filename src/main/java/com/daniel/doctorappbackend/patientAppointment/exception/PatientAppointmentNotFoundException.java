package com.daniel.doctorappbackend.patientAppointment.exception;

public class PatientAppointmentNotFoundException extends Exception{
    public PatientAppointmentNotFoundException(Long id){
        super(String.format("Patient appointment not found: %d", id));
    }
}
