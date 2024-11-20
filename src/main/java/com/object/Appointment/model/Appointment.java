package com.object.Appointment.model;

import com.object.Appointment.dto.DogDTO;
import com.object.Appointment.dto.OwnerDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appointmentDateTime;
    private String notes;
    private Long dogId;
    private Long ownerId;

    @Transient
    private DogDTO dog;

    @Transient
    private OwnerDTO owner;
}
