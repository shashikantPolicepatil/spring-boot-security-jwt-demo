package com.shashtech.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashtech.jwt.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);

}
