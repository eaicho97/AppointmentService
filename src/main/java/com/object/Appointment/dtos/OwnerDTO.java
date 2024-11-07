package com.object.Appointment.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OwnerDTO {
    private Long id;
    private String name;
    private String phone;
}
