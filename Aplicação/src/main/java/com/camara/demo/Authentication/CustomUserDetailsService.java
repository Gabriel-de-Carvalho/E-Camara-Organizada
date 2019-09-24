package com.camara.demo.Authentication;

import java.util.Optional;

import javax.transaction.Transactional;

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
		return user.orElseThrow(() -> new IllegalArgumentException("usuario nao existente"));
	}

}
