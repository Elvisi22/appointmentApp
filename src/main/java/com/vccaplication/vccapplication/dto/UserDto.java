package com.vccaplication.vccapplication.dto;

import com.vccaplication.vccapplication.entitiy.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;

    private String firstName;

    private String lastName;

    private Long idCard;

    private Integer age;

    private String location;
//    @NotNull(message = "Email should not be empty")

    private String email;
//    @NotNull(message = "Password should not be empty")
    private String password;

    private List<Appointment> appointment;
}
