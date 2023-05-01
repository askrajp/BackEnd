package com.askrademia.appointments.controller;

import com.askrademia.appointments.model.Appointment;
import com.askrademia.appointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentService.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        existingAppointment.setDateTime(updatedAppointment.getDateTime());
        existingAppointment.setUser(updatedAppointment.getUser());
        existingAppointment.setProfessional(updatedAppointment.getProfessional());
        return appointmentService.save(existingAppointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
    }
}
