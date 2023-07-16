package com.vccaplication.vccapplication.service.impl;

import com.vccaplication.vccapplication.dto.UserDto;
import com.vccaplication.vccapplication.entitiy.Role;
import com.vccaplication.vccapplication.entitiy.User;
import com.vccaplication.vccapplication.repository.RoleRepository;
import com.vccaplication.vccapplication.repository.UserRepository;
import com.vccaplication.vccapplication.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setIdCard(userDto.getIdCard());
        user.setAge(userDto.getAge());
        user.setLocation(userDto.getLocation());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }




    public void updateUser(User user){
        try{
            userRepository.save(user);

        }catch (Exception e){
            e.getMessage();
        }
    }

    public User update(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<UserDto> findByRoles(Long id) {
//        List<User> users = (List<User>) userRepository.findByRoles(1L);
//        return users.stream()
//                .map((user) -> mapToUserDto(user))
//                .collect(Collectors.toList());
//    }



    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setIdCard(user.getIdCard());
        userDto.setAge(user.getAge());
        userDto.setLocation(user.getLocation());
        userDto.setEmail(user.getEmail());
        userDto.setAppointment(user.getAppointment());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public User getCurrentUser() {
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(auth);
        return user;
    }

    @Override
    public void deleteByEmail(String email) {
        userRepository.delete(userRepository.findByEmail(email));
    }


}
