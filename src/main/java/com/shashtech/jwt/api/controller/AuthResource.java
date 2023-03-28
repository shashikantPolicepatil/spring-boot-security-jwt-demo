package com.shashtech.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shashtech.jwt.api.entity.AuthRequest;
import com.shashtech.jwt.api.util.JwtUtil;

@RestController
public class AuthResource {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/authenticate")
	public String geneToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch(Exception ex) {
			throw new Exception("Invalid username or password");
		}
		return jwtUtil.generateToken(authRequest.getUsername());
	}
}
