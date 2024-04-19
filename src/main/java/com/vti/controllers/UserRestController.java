package com.vti.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.UserModel;
import com.vti.services.implement.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping()
	public ResponseEntity<List<UserModel>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Optional<UserModel>> getUserById(@PathVariable long userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userId));
	}
	
	@PostMapping()
	public ResponseEntity<String> addUser(@RequestBody UserModel user) {
		boolean isInserted = userService.insert(user);
		if(isInserted)
			return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully!");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User added fail!");
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable long userId, @RequestBody UserModel user) {
		user.setUserId(userId);
		
		boolean isUpdated = userService.update(user);
		if(isUpdated)
			return ResponseEntity.status(HttpStatus.OK).body("User updated successfully!");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<String> updateInfoUser(@PathVariable long userId, @RequestBody Map<String, Object> updates) {
		boolean isUpdated = userService.updatePartial(userId, updates);
		if(isUpdated)
			return ResponseEntity.status(HttpStatus.OK).body("User updated successfully!");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId) {
		boolean isDeleted = userService.deleteById(userId);
		if(isDeleted)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	}
}
