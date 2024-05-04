package com.vti.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.services.implement.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	//Methods: Get user
	@GetMapping()
	public ResponseEntity<List<UserModel>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserModel> getUserById(@PathVariable long userId){
		Optional<UserModel> user = userService.getById(userId);
		return user.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
	}
	
	@GetMapping("/{userId}/groups")
	public ResponseEntity<Set<GroupModel>> getGroupsForUser(@PathVariable long userId){
		Set<GroupModel> groups = userService.getGroupsForUser(userId);
		return ResponseEntity.ok(groups);
	}
	
	//Methods: Create user
	@PostMapping()
	public ResponseEntity<String> createMewUser(@RequestBody UserModel user) {
		boolean isInserted = userService.insert(user);
		return isInserted
			? ResponseEntity.status(HttpStatus.CREATED).body("User added successfully!")
			: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User added fail!");
	}
	
	//Methods: Update user
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable long userId, @RequestBody UserModel user) {
		user.setUserId(userId);
		
		boolean isUpdated = userService.update(user);
		return isUpdated
			? ResponseEntity.ok("User updated successfully!")
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<String> updateUserNamePassword(@PathVariable long userId, @RequestBody Map<String, Object> updates) {
		boolean isUpdated = userService.updatePartial(userId, updates);
		return isUpdated
			? ResponseEntity.ok("User updated successfully!")
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
	}
	
	//Methods: Delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
		boolean isDeleted = userService.deleteById(userId);
		return isDeleted
			? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
			: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("{userId}/groups/{groupId}")
	public ResponseEntity<Void> removeUserFromGroup(
			@PathVariable long userId,
			@PathVariable long groupId){
		boolean isRemoved = userService.removeUserFromGroup(userId, groupId);
		return isRemoved
			? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
	}
	
}
