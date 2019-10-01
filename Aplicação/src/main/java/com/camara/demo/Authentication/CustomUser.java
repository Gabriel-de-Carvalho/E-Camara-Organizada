package com.camara.demo.Authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class CustomUser implements UserDetails{
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String email;
	
	private Date cadastro;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles = new ArrayList<>();
	
	public CustomUser() {
		
	}
	public CustomUser(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	};
	public CustomUser(String username, String password, String email, Date cadastro, List<String> roles) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.cadastro = cadastro;
		this.roles = roles;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getDate() {
		return this.cadastro;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String toString() {
		return (" nome: " + this.username + "\n email: " + this.email + " \n data de cadastro: " + this.cadastro.toGMTString());
	}
}
