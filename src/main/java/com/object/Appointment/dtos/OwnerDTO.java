package com.object.Appointment.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OwnerDTO {
    private Long id;
    private String name;
    private String phone;
}
