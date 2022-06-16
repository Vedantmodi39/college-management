package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.UserRegister;
import com.example.demo.Repository.UserRegisterRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
 @Autowired
 UserRegisterRepository userRegisterRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserRegister user= userRegisterRepository.findByUsername(username);	
		System.out.println("jjjj"+user);
		if(user == null){
			throw new UsernameNotFoundException("NO USER");			
		}
		return new CustomUserDetails(user);
	}

}
