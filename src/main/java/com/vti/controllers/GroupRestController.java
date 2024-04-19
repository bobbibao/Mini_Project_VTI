package com.vti.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.services.implement.GroupService;

@RestController
@RequestMapping(value = "/api/groups")
public class GroupRestController {

	@Autowired
	private GroupService groupService;

	public GroupRestController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	//Method: Get group
	@GetMapping()
	public ResponseEntity<List<GroupModel>> getAllGroups(){
		return ResponseEntity.status(HttpStatus.OK).body(groupService.getAll());
	}
	
	@GetMapping("/{groupId}")
	public ResponseEntity<GroupModel> getGroupById(@PathVariable long groupId){
		Optional<GroupModel> groupOpt = groupService.getById(groupId);
		return groupOpt.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
	}
	
	@GetMapping("/{groupId}/users")
	public ResponseEntity<Set<UserModel>> getMethodName(@PathVariable long groupId) {
		Set<UserModel> users = groupService.getUsersInGroup(groupId);
		return ResponseEntity.ok(users);
	}
	
}
