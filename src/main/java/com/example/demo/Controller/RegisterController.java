package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserRegister;
import com.example.demo.Services.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
		
	@PostMapping("/register/user")
	public UserRegister userLogin(@RequestBody UserRegister userLogin){	
		return registerService.userLogin(userLogin);		
   }
	
	@PostMapping("/register/admin")
	public UserRegister adminLogin(@RequestBody UserRegister userLogin){
	   return registerService.adminLogin(userLogin);
   }
	
}
