package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.Entity.UserRegister;


@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {
	
	@Autowired
	UserRegister user;
		
	public CustomUserDetails(UserRegister user) {
		super();
		this.user = user;
	}
	public UserRegister getUser() {
		return user;
	}

	public void setUser(UserRegister user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("inside Granted Autority");
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add( new SimpleGrantedAuthority( "ROLE_" + user.getRole()));
		System.out.println(list);
		return list;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
