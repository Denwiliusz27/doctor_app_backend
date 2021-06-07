package com.daniel.doctorappbackend.appointment;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/wizyty")
public class AppointmentController {
    public AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @GetMapping("/wszystkie")
    public List<Appointment> getAllAppointments(){
        return appointmentDao.findAll();
    }

    @GetMapping("/id-wizyty/{appointmentId}")
    public Optional<Appointment> getAppointmentById(@PathVariable long appointmentId){
        return appointmentDao.findById(appointmentId);
    }

    @GetMapping("/id-lekarza/{doctorId}")
    public Optional<Appointment> getAppointmentByDoctorId(@PathVariable long doctorId){
        return appointmentDao.findByDoctorId(doctorId);
    }

    @GetMapping("/id-pacjenta/{patientId}")
    public Optional<Appointment> getAppointmentByPatientId(@PathVariable long patientId){
        return appointmentDao.findByPatientId(patientId);
    }

    @GetMapping("/id-uslugi/{serviceId}")
    public Optional<Appointment> getAppointmentBySEerviceId(@PathVariable long serviceId){
        return appointmentDao.findByServiceId(serviceId);
    }

    @GetMapping("/id-dnia-wizyty/{dayId}")
    public Optional<Appointment> getAppointmentByDayId(@PathVariable long dayId){
        return appointmentDao.findByDayId(dayId);
    }

    @GetMapping("/id-statusu/{statusId}")
    public Optional<Appointment> getAppointmentByStatusId(@PathVariable long statusId){
        return appointmentDao.findByStatusId(statusId);
    }
}
