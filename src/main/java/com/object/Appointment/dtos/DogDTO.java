package com.object.Appointment.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DogDTO {
    private Long id;
    private String name;
    private String breed;
    private String ownerPhone;
}
