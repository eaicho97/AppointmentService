package com.object.Appointment.client;

import com.object.Appointment.dto.OwnerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "owner")
public interface OwnerClient {

    @GetMapping("/api/v1/owners")
    List<OwnerDTO> getAllOwners();

    @GetMapping("/api/v1/owners/{id}")
    OwnerDTO getOwnerById(@PathVariable("id") Long id);
}
