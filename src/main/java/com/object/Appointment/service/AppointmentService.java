package com.object.Appointment.service;

import com.object.Appointment.dtos.DogDTO;
import com.object.Appointment.dtos.OwnerDTO;
import com.object.Appointment.model.Appointment;
import com.object.Appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private RestTemplate restTemplate;

    @Value("${dog.service.url}")
    private String dogServiceUrl;

    @Value("${owner.service.url}")
    private String ownerServiceUrl;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, RestTemplate restTemplate){
        this.appointmentRepository = appointmentRepository;
        this.restTemplate = restTemplate;
    }
    public DogDTO getDogById(Long dogId){
        String url = dogServiceUrl + "/" + dogId;
        return restTemplate.getForObject(url, DogDTO.class);
    }

    public OwnerDTO getOwnerById(Long ownerId){
        String url = ownerServiceUrl + "/" + ownerId;
        return restTemplate.getForObject(url, OwnerDTO.class);
    }

    public Appointment createAppointment(Appointment appointment){
        DogDTO dog = getDogById(appointment.getDogId());
        OwnerDTO owner = getOwnerById(appointment.getOwnerId());

        if (dog == null || owner == null){
            throw new RuntimeException("Dog or Owner not found");
        }
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment updateAppointment(Long id, Appointment appointmentDetails){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment"));
        appointment.setAppointmentDateTime(appointmentDetails.getAppointmentDateTime());
        appointment.setNotes(appointmentDetails.getNotes());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}
