package com.vccaplication.vccapplication.controller;

import com.vccaplication.vccapplication.entitiy.Appointment;
import com.vccaplication.vccapplication.entitiy.MyAppointments;
import com.vccaplication.vccapplication.service.AdminAppointemntService;
import com.vccaplication.vccapplication.service.AppointmentService;
import com.vccaplication.vccapplication.service.MyAppointmentService;
import com.vccaplication.vccapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    private final UserService service;
    private final AppointmentService appointmentService;
    private final AdminAppointemntService adminAppointemntService;

    private final MyAppointmentService myAppointmentService;

    public AdminController(UserService service, AppointmentService appointmentService, AdminAppointemntService adminAppointemntService, MyAppointmentService myAppointmentService) {
        this.service = service;
        this.appointmentService = appointmentService;
        this.adminAppointemntService = adminAppointemntService;
        this.myAppointmentService = myAppointmentService;
    }

    @RequestMapping(value = "/adminAppointments")
    public String home(){
        return "adminAppointments";
    }

    @GetMapping("/all_appointmentsAdmin")
    public ModelAndView getAllAppointmentsAdmin() {
        List<Appointment> list = appointmentService.getAllAppointments();
        return new ModelAndView("appointmentListForAdmin", "appointment", list);
    }

    @RequestMapping("/appointmentReview/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Appointment a = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", a);
        return "appointmentReviewAdmin";
    }

    @PostMapping("/saveAdmin")
    public String addAppointment(@ModelAttribute Appointment a) {
        appointmentService.save(a);
        return "redirect:/all_appointmentsAdmin";
    }
    @RequestMapping("/deleteAppointmentAdmin/{id}")
    public String delete(@PathVariable("id") int id) {
        appointmentService.deleteById(id);
        return "redirect:/adminAppointments";
    }

    @GetMapping("my_appointmentsAdmin")
    public String getMyAppointments(Model model) {
        List<MyAppointments> list = myAppointmentService.getAllMyAppointments();
        model.addAttribute("appointment", list);
        return "myAppointmentsAdmin";
    }

    @RequestMapping("/mylistAdmin/{id}")
    public String getMyList(@PathVariable("id") Integer id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        MyAppointments ma = new MyAppointments(appointment.getId(),
                appointment.getName(), appointment.getDate(), appointment.getType() , appointment.getUsername() , appointment.getDescription() , appointment.isConfirmation());
        myAppointmentService.saveMyAppointment(ma);
        return "redirect:/all_appointmentsAdmin";
    }

//
//    @GetMapping("my_appointmentsAdmin")
//    public String getMyAppointments(Model model) {
//        List<MyAppointments> list = adminAppointemntService.getAllMyAppointments();
//        model.addAttribute("appointment", list);
//        return "myAppointmentsAdmin";
//    }
//
////    @GetMapping("my_appointments")
////    public String getMyAppointments(Model model) {
////        List<MyAppointments> list = adminAppointemntService.getAllMyAppointments();
////        model.addAttribute("appointment", list);
////        return "myAppointments";
////    }
//
////    @RequestMapping("/appointmentEdit/{id}")
////    public String edit(@PathVariable("id") int id, Model model) {
////        Appointment a = appointmentService.getAppointmentById(id);
////        model.addAttribute("appointment", a);
////        return "appointmentEdit";
////    }
////
////    @RequestMapping("/deleteAppointment/{id}")
////    public String delete(@PathVariable("id") int id) {
////        appointmentService.deleteById(id);
////        return "redirect:/my_appointmentsAdmin";
////    }
}
