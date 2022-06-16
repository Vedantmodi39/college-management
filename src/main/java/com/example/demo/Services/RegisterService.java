package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserRegister;
import com.example.demo.Repository.UserRegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRegisterRepository userLoginRepository;
	
	

	public UserRegister userLogin(UserRegister userRegister) {

		userRegister.setRole("User");	
		userRegister.setPassword( bCryptPasswordEncoder.encode(userRegister.getPassword() ) );	
		return userLoginRepository.save(userRegister);
	}



	public UserRegister adminLogin(UserRegister userRegister) {
		
		userRegister.setRole("Admin");
		userRegister.setPassword( bCryptPasswordEncoder.encode(userRegister.getPassword() ) );
		return userLoginRepository.save(userRegister);
	}
	
	
	

}
