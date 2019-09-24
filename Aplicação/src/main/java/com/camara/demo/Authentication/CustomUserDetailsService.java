package com.camara.demo.Authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository users;
	
	public CustomUserDetailsService() {
		super();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username){
		// TODO Auto-generated method stub
		Optional<CustomUser> user = users.findByUsername(username);
		return user.orElseThrow(() -> new NullPointerException("usuario nao existente"));
	}

}
