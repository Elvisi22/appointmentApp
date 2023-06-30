package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.entitiy.Appointment;
import com.vccaplication.vccapplication.repository.AppointmentRepository;
import com.vccaplication.vccapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
//changed
    @Autowired
    private UserRepository userRepository;


    public void save(Appointment appointment){

        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsforUser(String email){
        return Collections.singletonList(appointmentRepository.findAppointmentByUsername(email));
    }


    public Appointment getAppointmentById(Integer id){
        return appointmentRepository.findById(id).get();
    }

    public void deleteById(int id){
        appointmentRepository.deleteById(id);
    }
}
