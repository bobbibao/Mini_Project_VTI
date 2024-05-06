package com.vti.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.services.implement.GroupService;

@CrossOrigin("*")
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
	public ResponseEntity<Set<UserModel>> getUsersInGroup(@PathVariable long groupId) {
		Set<UserModel> users = groupService.getUsersInGroup(groupId);
		return ResponseEntity.ok(users);
	}
	
	//Method: Create group
	@PostMapping()
	public ResponseEntity<GroupModel> createNewGroup(@RequestBody GroupModel group){
		boolean isInserted = groupService.insert(group);
		return isInserted
			? ResponseEntity.status(HttpStatus.CREATED).body(group)
			: ResponseEntity.internalServerError().build();
	}
	
	//Method: Update group
	@PutMapping("/{groupId}")
	public ResponseEntity<GroupModel> updateGroup(@PathVariable long groupId, @RequestBody GroupModel group){
		group.setGroupId(groupId);
		boolean isUpdated = groupService.update(group);
		return isUpdated
			? ResponseEntity.ok(group)
			: ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{groupId}")
	public ResponseEntity<String> updateGroupName(
			@PathVariable long groupId, @RequestBody Map<String, Object> updates){
		boolean isUpdated = groupService.updatePartial(groupId, updates);
		return isUpdated
			? ResponseEntity.ok("Group updated successfully!")
			: ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{groupId}/users/{userId}")
	public ResponseEntity<String> addUserToGroup(@PathVariable long groupId, @PathVariable long userId){
		boolean isAdded = groupService.addUserToGroup(groupId, userId);
		return isAdded
			? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("User/group not found");
	}
	
	//Method: Delete
	@DeleteMapping("/{groupId}")
	public ResponseEntity<Void> deleteGroup(@PathVariable long groupId){
		boolean isDeleted = groupService.deleteById(groupId);
		return isDeleted
			? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{groupId}/users/{userId}")
	public ResponseEntity<Void> removeUserFromGroup(@PathVariable long groupId, @PathVariable long userId){
		boolean isDeleted = groupService.removeUserFromGroup(groupId, userId);
		return isDeleted
			? ResponseEntity.noContent().build()
			: ResponseEntity.notFound().build();
	}
}
