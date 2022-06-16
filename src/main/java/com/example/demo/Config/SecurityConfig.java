package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Services.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
	System.out.println("auth"+auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder()));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();

	// http.authorizeRequests().antMatchers("/rest/**").permitAll().and().
	// authorizeRequests().antMatchers("/secure/**").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().permitAll();



	http
	.httpBasic()
	.and()
	.authorizeRequests()
	.antMatchers("/admin/getStudent").hasAnyRole("User" , "Admin")
	.antMatchers("/admin/**").hasAnyRole("Admin")
	.antMatchers("/register/**").permitAll()
	
	
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder ()
	{
		 return new BCryptPasswordEncoder();
	}

}
