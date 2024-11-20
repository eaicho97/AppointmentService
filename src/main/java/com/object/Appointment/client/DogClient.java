package com.object.Appointment.client;

import com.object.Appointment.dto.DogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "dog")
public interface DogClient {

    @GetMapping("/api/v1/dogs")
    List<DogDTO> getAllDogs();

    @GetMapping("/api/v1/dogs/{id}")
    DogDTO getDogById(@PathVariable("id") Long id);
}
