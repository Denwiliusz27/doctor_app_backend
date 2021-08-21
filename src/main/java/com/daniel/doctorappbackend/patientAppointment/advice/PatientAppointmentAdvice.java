package com.daniel.doctorappbackend.patientAppointment.advice;

import com.daniel.doctorappbackend.patientAppointment.exception.PatientAppointmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PatientAppointmentAdvice {
    @ExceptionHandler(PatientAppointmentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handlePatientAppointmentNotFoundExcepion(PatientAppointmentNotFoundException ex) {
        return ex.getMessage();
    }
}
