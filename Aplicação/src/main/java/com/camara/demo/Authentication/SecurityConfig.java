package com.camara.demo.Authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Bean
     @Override
     protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		.cors()
		.and()
		.authorizeRequests().anyRequest().authenticated()
		.antMatchers(HttpMethod.GET,"/api/v1/deputado/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/v1/partido/").permitAll()
		.antMatchers(HttpMethod.GET, "/api/v1/projetos/**").permitAll()
		.antMatchers("/api/v1/auth/**").permitAll();
		
		httpSecurity.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}