package com.vccaplication.vccapplication.repository;

import com.vccaplication.vccapplication.entitiy.MyAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAppointmentRepository extends JpaRepository<MyAppointments , Integer> {


//    @Query(value = "")
//    List<MyAppointments> getMyAppointmentsByUserId(Long userId);
}
