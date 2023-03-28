package com.shashtech.jwt.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String getText() {
		System.out.println("");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return "working";
	}
}
