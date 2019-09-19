package Authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.jsonwebtoken.Jwts;

public class JWTTokenProvider {
	    private static final String SECRET = "5ea7750aa9d3e10832a9b800b87f50e7";
	    private static final long EXPIRATION_TIME = 864_000_000; // 10 DIAS
	    private static final String TOKEN_PREFIX = "Bearer ";
	    private static final String HEADER_STRING = "Authorization";
	    
	    @Autowired
	    public UserDetailsService  userService;
	    
	    public static String generateToken() {
	    	
	    	return null;
	    }
	    
	    public static String resolveToken() {
	    	return null;
	    }
	    
	    public static Authentication getAuthentication(HttpServletRequest request) {
	    	String token = request.getHeader("Authorizathion").substring(7);
	    	UserDetails usuario = userService.loadByUserName(token);
	    		
	    	
	    	if (token != null) {
	    		String user = Jwts.parser()
	    						.setSigningKey(SECRET)
	    						.parseClaimsJws(token)
	    						.getBody()
	    						.getSubject();
	    			return new UsernamePasswordAuthenticationToken(user, null);
	    	}
	    	
	    	return null;
	    }


}
