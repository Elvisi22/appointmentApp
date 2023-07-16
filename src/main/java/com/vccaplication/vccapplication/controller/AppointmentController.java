package com.vccaplication.vccapplication.controller;

import com.vccaplication.vccapplication.entitiy.Appointment;
import com.vccaplication.vccapplication.repository.UserRepository;
import com.vccaplication.vccapplication.service.AppointmentService;
import com.vccaplication.vccapplication.service.MyAppointmentService;
import com.vccaplication.vccapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService service;
    @Autowired
    private MyAppointmentService myAppointmentService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;



    @GetMapping("/appointment")
    public String appointments() {
        return "appointments";
    }


    @GetMapping("/appointment_creation")
    public String appointmentCreation() {
        return "appointmentCreation";
    }



    @GetMapping("/all_appointments")
    public ModelAndView getAllAppointments() {
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Appointment> list = service.getAppointmentsforUser(auth);
        return new ModelAndView("appointmentList", "appointment", list);
    }


    @PostMapping("/save")
    public String addAppointment(@ModelAttribute Appointment a) {
        service.save(a);
        return "redirect:/all_appointments";
    }


//    @GetMapping("my_appointments")
//    public String getMyAppointments(Model model) {
//        List<MyAppointments> list = myAppointmentService.getAllMyAppointments();
//        model.addAttribute("appointment", list);
//        return "myAppointments";
//    }


    //retrive id from the url
//    @RequestMapping("/mylist/{id}")
//    public String getMyList(@PathVariable("id") Integer id) {
//        Appointment appointment = service.getAppointmentById(id);
//        MyAppointments ma = new MyAppointments(appointment.getId(),
//                appointment.getName(), appointment.getDate(), appointment.getType() , appointment.getUsername());
//        myAppointmentService.saveMyAppointment(ma);
//        return "redirect:/all_appointments";
//    }

    @RequestMapping("/appointmentEdit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Appointment a = service.getAppointmentById(id);
        model.addAttribute("appointment", a);
        return "appointmentEdit";
    }

    @RequestMapping("/deleteAppointment/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/appointment";
    }


}
