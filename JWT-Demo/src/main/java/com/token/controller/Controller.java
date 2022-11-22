package com.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.entity.JwtRequest;
import com.token.entity.JwtResponse;
import com.token.service.UserService;
import com.token.utility.JWTUtility;

@RestController
public class Controller {
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String home() {
		return "I am KIRTISHIL DHIWAR....Authorized person";
	}

	
	@PostMapping("/auth")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (jwtRequest.getUsername(),jwtRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Invalid Credentials");
		}
		
		final UserDetails userDetail= userService.loadUserByUsername(jwtRequest.getUsername());
		 final String token = jwtUtility.generateToken(userDetail);
		 return new JwtResponse(token);
	}
}
