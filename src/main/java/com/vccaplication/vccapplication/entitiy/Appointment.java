package com.vccaplication.vccapplication.entitiy;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(nullable=false)
    private String name;
//    @Column(nullable=false)
//    private String date;
//    @Column(nullable=false)

    private LocalDate date;
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //edited

    private String username;

    private String description;

    private boolean confirmation;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
// Getter and setter for User



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Appointment(Integer id, String name, LocalDate datePlannedMeeting, String type , String description , boolean confirmation) {
        super();
        this.id = id;
        this.name = name;
        this.date = datePlannedMeeting;
        this.type = type;
        this.description = description;
        this.confirmation = confirmation;

    }

    public Appointment() {
        super();
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

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public void setUserId(Long currentUserId) {
        User user = new User();
        user.setId(currentUserId);
        this.user = user;
    }


}
