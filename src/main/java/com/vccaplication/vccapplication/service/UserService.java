package com.vccaplication.vccapplication.service;

import com.vccaplication.vccapplication.dto.UserDto;
import com.vccaplication.vccapplication.entitiy.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    public User getCurrentUser();
}
