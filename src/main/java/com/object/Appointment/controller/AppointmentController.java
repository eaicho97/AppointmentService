package com.object.Appointment.controller;

import com.object.Appointment.dtos.AppointmentResponseDTO;
import com.object.Appointment.model.Appointment;
import com.object.Appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping
    public List<AppointmentResponseDTO> getAllAppointments(){
        return appointmentService.getAllAppointments().stream()
                .map(appointment -> {
                    var dog = appointmentService.getDogById(appointment.getDogId());
                    var owner = appointmentService.getOwnerById(appointment.getOwnerId());
                    return new AppointmentResponseDTO(appointment, dog, owner);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentsById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id)
                .map(appointment -> {
                    var dog = appointmentService.getDogById(appointment.getDogId());
                    var owner = appointmentService.getOwnerById(appointment.getOwnerId());
                    return ResponseEntity.ok(new AppointmentResponseDTO(appointment, dog, owner));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails){
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointmentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
