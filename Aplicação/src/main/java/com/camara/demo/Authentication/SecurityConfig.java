package com.camara.demo.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService serviceUser;
	  
	 @Bean
     @Override
     protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
	 
	 @Bean
	 public static PasswordEncoder passwordEncoder() {
	       return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 }

	 
	  @Autowired
	  @Override
	  public void configure(final AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(serviceUser).passwordEncoder(passwordEncoder());
	  }
	  
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(serviceUser);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	  	
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable()
		
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/v1/deputado/**").permitAll()
		.antMatchers(HttpMethod.GET, "/v1/partido/**").permitAll()
		.antMatchers(HttpMethod.GET, "/v1/projetos/**").permitAll()
		.antMatchers("/v1/auth/**").permitAll()
		.anyRequest().authenticated();
		
//		httpSecurity.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}