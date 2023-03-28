package com.shashtech.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shashtech.jwt.api.entity.User;
import com.shashtech.jwt.api.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
	}

	@PostConstruct
	public void initUsers() {
		List<User> usersList = Stream.of(new User(101,"name","password","email"),
				new User(102,"name2","password","email")
				,new User(103,"name3","password","email"),
				new User(104,"name4","password","email")).collect(Collectors.toList());
		repository.saveAll(usersList);
	}
	
	
}
