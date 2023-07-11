package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.entitiy.Appointment;
import com.vccaplication.vccapplication.repository.AppointmentRepository;
import com.vccaplication.vccapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AppointmentService {
    Logger LOG=  LoggerFactory.getLogger(AppointmentService.class);
    @Autowired
    private AppointmentRepository appointmentRepository;
//changed
    @Autowired
    private UserRepository userRepository;


    public void save(Appointment appointment){
        LOG.info("Saving appointment: {}", appointment.toString());
        try{
            appointmentRepository.save(appointment);

        }catch (Exception e){
            LOG.error("Appointment was not saved .....");
            LOG.error(e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsforUser(String email){
        return appointmentRepository.findAppointmentByUsername(email);
    }


    public Appointment getAppointmentById(Integer id){
        return appointmentRepository.findById(id).get();
    }

    public void deleteById(int id){
        appointmentRepository.deleteById(id);
    }
}
