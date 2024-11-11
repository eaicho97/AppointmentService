package com.object.Appointment.repository;

import com.object.Appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
