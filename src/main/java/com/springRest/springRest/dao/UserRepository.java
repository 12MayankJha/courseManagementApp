package com.springRest.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springRest.springRest.entities.regAndLogin.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
