package com.udemy.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.hruser.entities.User;
import com.udemy.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "users")
public class UserResources {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		return ResponseEntity.ok(repository.findByEmail(email));
	}
	
}