package com.gymcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymcrm.model.User;
import com.gymcrm.service.implementation.UserServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserServiceImplementation userServiceImplementation;
	
	@Autowired
	public UserController(UserServiceImplementation userServiceImplementation) {
		this.userServiceImplementation = userServiceImplementation;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userServiceImplementation.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId){
		User user = userServiceImplementation.getUserById(userId);
		if(user != null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		userServiceImplementation.saveUser(user);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @Valid @RequestBody User updatedUser){
		userServiceImplementation.updateUser(userId, updatedUser);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
		userServiceImplementation.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
