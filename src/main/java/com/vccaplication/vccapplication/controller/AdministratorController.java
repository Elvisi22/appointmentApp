package com.vccaplication.vccapplication.controller;

import com.vccaplication.vccapplication.dto.UserDto;
import com.vccaplication.vccapplication.entitiy.User;
import com.vccaplication.vccapplication.repository.UserRepository;
import com.vccaplication.vccapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdministratorController {

    private UserService userService;
    private final UserRepository userRepository;

    public AdministratorController(UserService userService,
                                   UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/administrator")
    public String home(){
        return "administrator";
    }

    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @RequestMapping("/usersEdit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        User user = userService.findUserByEmail(email);
        model.addAttribute("user", user);
        return "usersEdit";
    }

//    @PostMapping("/saveUser")
//    public String saveDetails(User user) {
//        userService.update(user);
//        return "redirect:/users";
//    }

    @RequestMapping("/deleteUser/{email}")
    public String delete(@PathVariable("email") String email) {
        userService.deleteByEmail(email);
        return "redirect:/users";
    }


}
