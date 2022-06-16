	package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.UserRegister;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister, Integer> {

	UserRegister findByUsername(String username);
}
