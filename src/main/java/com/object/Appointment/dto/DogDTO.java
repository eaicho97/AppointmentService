package com.object.Appointment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DogDTO {
    private Long id;
    private String name;
    private String breed;
    private String ownerPhone;
}
