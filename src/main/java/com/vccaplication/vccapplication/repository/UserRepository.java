package com.vccaplication.vccapplication.repository;

import com.vccaplication.vccapplication.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
//    User findUsersById(Long id);
//
//    User findCurrentUser(Long id);
//    User findUsersByName(String name);


}