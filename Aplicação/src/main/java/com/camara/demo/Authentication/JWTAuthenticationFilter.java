package com.camara.demo.Authentication;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class JWTAuthenticationFilter extends GenericFilterBean{
	
	@Autowired
	public JWTTokenProvider jwtProvider;
	
	public JWTAuthenticationFilter() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String token = null;
		String username = null;
		
		String requestToken = ((HttpServletRequest) request).getHeader("Authorization");
		if(requestToken != null && requestToken.startsWith("bearer ")) {
			token = requestToken.substring(7);
			if(jwtProvider.validateToken(token)) {
				Authentication auth = jwtProvider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);
	}
}
