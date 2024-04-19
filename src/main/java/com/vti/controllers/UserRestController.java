package com.vti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.UserModel;
import com.vti.services.implement.UserService;
import org.springframework.web.bind.annotation.GetMapping;


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
	
}
