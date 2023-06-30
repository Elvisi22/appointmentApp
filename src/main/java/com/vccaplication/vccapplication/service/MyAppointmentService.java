package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.entitiy.MyAppointments;
import com.vccaplication.vccapplication.repository.MyAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAppointmentService {

    private  final MyAppointmentRepository myAppointmentRepository;



    public MyAppointmentService( MyAppointmentRepository myAppointmentRepository ,UserService userService) {
        this.myAppointmentRepository = myAppointmentRepository;

    }

    public void saveMyAppointment(MyAppointments appointments){
        myAppointmentRepository.save(appointments);
    }

    public List<MyAppointments> getAllMyAppointments(){
        return myAppointmentRepository.findAll();
    }
    //new
//    List<MyAppointments> getAppointmentsByUserId(){
//        Long userId = userService.getCurrentUser().getId();
//        List<MyAppointments> myAppointments = myAppointmentRepository.get
//    }

    public void deleteById(int id){
        myAppointmentRepository.deleteById(id);
    }
}
