package com.vccaplication.vccapplication.controller;

import com.vccaplication.vccapplication.service.MyAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAppointmentsController {

    @Autowired
    private MyAppointmentService service;

    @RequestMapping("/deleteMyAppointment/{id}")
    public String deleteMyAppointment(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/my_appointments";
    }



}
