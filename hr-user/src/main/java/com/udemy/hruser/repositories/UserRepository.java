package com.udemy.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}