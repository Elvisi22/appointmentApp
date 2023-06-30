package com.vccaplication.vccapplication.repository;

import com.vccaplication.vccapplication.entitiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
