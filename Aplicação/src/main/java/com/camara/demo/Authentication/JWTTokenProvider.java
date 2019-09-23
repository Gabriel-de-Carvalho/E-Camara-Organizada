package com.camara.demo.Authentication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenProvider {
	    private static final String SECRET = "5ea7750aa9d3e10832a9b800b87f50e7";
	    private static final long EXPIRATION_TIME = 864_000_000; // 10 DIAS
	    private static final String TOKEN_PREFIX = "Bearer ";
	    private static final String HEADER_STRING = "Authorization";
	    
	    @Autowired
	    public static UserDetailsService  userService;
	    
	    public static String generateToken(String username) {
	    	return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	    			.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	    }
	    
	    public boolean validateToken(String token) {
	    	try {
		    	Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
		    	if(claims.getBody().getExpiration().before(new Date())) {
		    		return false;
		    	}
		    	
		    	return true;
	    	} catch (JwtException| IllegalArgumentException e) {
	    		throw new IllegalArgumentException("Expired or invalid token");
	    	}
	    }
	    
	    public static String getUserNameFromToken(String token) {
	    	String user = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
	    	return user;
	    }
	    
	    public static Authentication getAuthentication(String token) {
	    	
	    	if (token != null) {
	    		UserDetails user = userService.loadUserByUsername(getUserNameFromToken(token));
	    		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	    	}
	    	return null;
	    }


}
