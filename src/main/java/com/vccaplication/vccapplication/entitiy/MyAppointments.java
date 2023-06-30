package com.vccaplication.vccapplication.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="MyAppointment")
public class MyAppointments {
    @Id
    @Column(name = "appointment_id")
    private Integer id;
    private String name;
//    private String date;
    private LocalDate date;
    private String type;

    private String username;

    private String description;

    private boolean confirmation;

    public MyAppointments(Integer id, String name, LocalDate date,
                          String type , String username , String description ,boolean confirmation) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.username = username;
        this.description = description;
        this.confirmation = confirmation;
    }

    public MyAppointments() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
