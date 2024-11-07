package com.object.Appointment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
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
