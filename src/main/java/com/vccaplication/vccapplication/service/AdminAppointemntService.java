package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.entitiy.MyAppointments;
import com.vccaplication.vccapplication.repository.AdminAppointmentRepository;
import com.vccaplication.vccapplication.repository.MyAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAppointemntService {

    private  final MyAppointmentRepository myAppointmentRepository;
    private final AdminAppointmentRepository repository;



    public AdminAppointemntService(MyAppointmentRepository myAppointmentRepository , UserService userService, AdminAppointmentRepository repository) {
        this.myAppointmentRepository = myAppointmentRepository;

        this.repository = repository;
    }

    public void saveMyAppointment(MyAppointments appointments){
        repository.save(appointments);
    }

    public List<MyAppointments> getAllMyAppointments(){
        return repository.findAll();
    }
    //new
//    List<MyAppointments> getAppointmentsByUserId(){
//        Long userId = userService.getCurrentUser().getId();
//        List<MyAppointments> myAppointments = myAppointmentRepository.get
//    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
