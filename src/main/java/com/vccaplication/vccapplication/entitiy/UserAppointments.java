package com.vccaplication.vccapplication.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userAppointment")
public class UserAppointments {
    @Id
    @Column(name = "appointment_id")
    private Integer id;
    private String name;
    private String date;
    private String type;
    private String userName;

    public UserAppointments(Integer id, String name, String date, String type, String userName) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.userName = userName;
    }

    public UserAppointments() {

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
