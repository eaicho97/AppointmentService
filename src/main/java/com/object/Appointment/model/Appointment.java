package com.object.Appointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime appointmentDateTime;
    private String notes;

    @Column(nullable = false)
    private Long dogId;

    @Column(nullable = false)
    private Long ownerId;

}
