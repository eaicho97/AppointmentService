package com.object.Appointment.service;

import com.object.Appointment.model.Appointment;
import com.object.Appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment updateAppointment(Long id, Appointment appointmentDetails){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment"));
        appointment.setAppointmentDateTime(appointmentDetails.getAppointmentDateTime());
        appointment.setNotes(appointmentDetails.getNotes());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}
