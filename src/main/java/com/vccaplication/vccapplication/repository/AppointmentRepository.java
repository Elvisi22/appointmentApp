package com.vccaplication.vccapplication.repository;

import com.vccaplication.vccapplication.entitiy.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

//    @Query("SELECT u FROM Appointment u WHERE u.username = ?#{authentication.authenticated}")
//    Optional<Appointment> findAppointmentByUser();

    Appointment findAppointmentByUsername(String email);

//    Optional<Appointment> findAppointmentsForThisUser(@Nullable Object unknownAttr1);



}
