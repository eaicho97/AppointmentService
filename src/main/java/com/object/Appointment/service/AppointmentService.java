package com.object.Appointment.service;

import com.object.Appointment.client.DogClient;
import com.object.Appointment.client.OwnerClient;
import com.object.Appointment.dto.DogDTO;
import com.object.Appointment.dto.OwnerDTO;
import com.object.Appointment.model.Appointment;
import com.object.Appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

    @Autowired
    private final DogClient dogClient;

    @Autowired
    private final OwnerClient ownerClient;

    public AppointmentService(AppointmentRepository appointmentRepository, DogClient dogClient, OwnerClient ownerClient){
        this.appointmentRepository = appointmentRepository;
        this.dogClient = dogClient;
        this.ownerClient = ownerClient;
    }

    public List<DogDTO> getDogs(){
        return dogClient.getAllDogs();
    }

    public List<OwnerDTO> getOwners(){
        return ownerClient.getAllOwners();
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = appointmentRepository.findAll();

        for (Appointment appointment : appointments){
            DogDTO dog = dogClient.getDogById(appointment.getDogId());
            OwnerDTO owner = ownerClient.getOwnerById(appointment.getOwnerId());

            appointment.setDog(dog);
            appointment.setOwner(owner);
        }
        return appointments;
    }

    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }

    public Appointment createAppointment(Appointment appointment){
        DogDTO dog = dogClient.getDogById(appointment.getDogId());
        if (dog == null){
            throw new IllegalArgumentException("Dog with ID" + appointment.getDogId() + "does not exist.");
        }

        OwnerDTO owner = ownerClient.getOwnerById(appointment.getOwnerId());
        if (owner == null){
            throw new IllegalArgumentException("Owner with ID" + appointment.getOwnerId() + " does not exist");
        }

        Appointment savedAppointment = appointmentRepository.save(appointment);

        savedAppointment.setDog(dog);
        savedAppointment.setOwner(owner);

        return savedAppointment;
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment){
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " does not exist."));

        DogDTO dog = dogClient.getDogById(updatedAppointment.getDogId());
        if (dog == null){
            throw new IllegalArgumentException("Dog with ID " + updatedAppointment.getDogId() + " does not exist.");
        }

        OwnerDTO owner = ownerClient.getOwnerById(updatedAppointment.getOwnerId());
        if (owner == null){
            throw new IllegalArgumentException("Dog with ID " + updatedAppointment.getDogId() + " does not exist.");
        }

        existingAppointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
        existingAppointment.setNotes(updatedAppointment.getNotes());
        existingAppointment.setDogId(updatedAppointment.getDogId());
        existingAppointment.setOwnerId(updatedAppointment.getOwnerId());

        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id){
        if (!appointmentRepository.existsById(id)){
            throw new IllegalArgumentException("Appointment with ID "+id+" does not exist.");
        }
        appointmentRepository.deleteById(id);
    }
}
