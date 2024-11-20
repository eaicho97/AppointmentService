package com.object.Appointment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerDTO {
    private Long id;
    private String name;
    private String phone;
}
