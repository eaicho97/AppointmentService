package com.object.Appointment.dtos;

import com.object.Appointment.model.Appointment;
import lombok.Data;

@Data
public class AppointmentResponseDTO {

    private Long id;
    private String appointmentDateTime;
    private String notes;
    private DogDTO dog;
    private OwnerDTO owner;

    public AppointmentResponseDTO(Appointment appointment, DogDTO dog, OwnerDTO owner){
        this.id = appointment.getId();
        this.appointmentDateTime = appointment.getAppointmentDateTime().toString();
        this.notes = appointment.getNotes();
        this.dog = dog;
        this.owner = owner;
    }
}
