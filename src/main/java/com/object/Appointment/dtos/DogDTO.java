package com.object.Appointment.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DogDTO {
    private Long id;
    private String name;
    private String breed;
    private String ownerPhone;
}
