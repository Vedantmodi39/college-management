package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Integer> {

	UserRegister findByUsername(String username);



}
