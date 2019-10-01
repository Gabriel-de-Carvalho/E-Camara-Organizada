package com.camara.demo.Authentication;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {
	
	private JWTTokenProvider jwtProvider;
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();

	
	@PostMapping("/signup")
	public ResponseEntity signup(@RequestBody CustomUser user) {
			if(userRepo.findByUsername(user.getUsername()).isPresent()) {
				throw new EntityExistsException("Usuario ja cadastrado");
			}
			Set<ConstraintViolation<CustomUser>> violation = validator.validate(user);
			
			if(violation.size() > 0) {
				for(ConstraintViolation<CustomUser> violate : violation) {
					throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, violate.getMessage());
				}
			}
			
			CustomUser newUser = new CustomUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getEmail(), new Date(), Arrays.asList("ROLE_USER"));
			CustomUser resposta = (CustomUser) userRepo.save(newUser);
			
			return new ResponseEntity<String>(resposta.toString(), HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity signin(@RequestBody CustomUser user) {
		try {
		String username = user.getUsername();
		Optional<CustomUser> userDb = userRepo.findByUsername(username);
		CustomUser customUser = userDb.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario inexistente"));
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customUser.getUsername(),  user.getPassword(), user.getAuthorities()));
		String token = jwtProvider.generateToken(customUser.getUsername());
		
		Map<String,String> resposta = new HashMap<>();
		resposta.put("username", customUser.getUsername());
		resposta.put("token", token);
		
		return new ResponseEntity(resposta, HttpStatus.OK);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Usuario/Senha inválidos");
		}
	}
}


