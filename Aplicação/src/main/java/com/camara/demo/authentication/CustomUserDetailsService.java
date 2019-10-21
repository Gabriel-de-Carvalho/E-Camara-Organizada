package com.camara.demo.authentication;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;




@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private UserRepository users;
	
	public CustomUserDetailsService(UserRepository users) {
		this.users = users;
	}

	
	@Override
	public UserDetails loadUserByUsername(String username){
		// TODO Auto-generated method stub
		Optional<CustomUser> user = users.findByUsername(username);
		return user.orElseThrow(() -> new NullPointerException("usuario nao inexistente"));
	}
	
}
