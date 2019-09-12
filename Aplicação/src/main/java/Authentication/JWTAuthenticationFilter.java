package Authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import SecurityConstants.*;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.camara.demo.models.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException{
		try {
			Pessoa creds = new ObjectMapper().readValue(req.getInputStream(), Pessoa.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
																	creds.getNome(), creds.getDni(), new ArrayList<>()));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, 
											FilterChain chain, Authentication auth) throws IOException{
		
		String token = JWT.create().withSubject(((User) auth.getPrincipal()).getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)).sign(HMAC512(SecurityConstants.SECRET.getBytes()));
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		
	}
}
