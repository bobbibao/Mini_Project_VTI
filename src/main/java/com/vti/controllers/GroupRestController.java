package com.vti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.models.GroupModel;
import com.vti.services.implement.GroupService;

@RestController
@RequestMapping(value = "/api/groups")
public class GroupRestController {

	@Autowired
	private GroupService groupService;

	public GroupRestController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	@GetMapping()
	public ResponseEntity<List<GroupModel>> getAllGroups(){
		return ResponseEntity.status(HttpStatus.OK).body(groupService.getAll());
	}
}
