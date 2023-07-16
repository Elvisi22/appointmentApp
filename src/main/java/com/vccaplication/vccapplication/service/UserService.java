package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.dto.UserDto;
import com.vccaplication.vccapplication.entitiy.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);


//    void updateUser(User user);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();


//   List<UserDto> findByRoles(Long id);

    //new
//    List<UserDto> findByRoles();

    public User getCurrentUser();

    void deleteByEmail(String email);


    User update(User user);
}
