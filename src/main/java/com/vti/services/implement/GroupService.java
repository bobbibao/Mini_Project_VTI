package com.vti.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.repositories.IGroupRepository;
import com.vti.repositories.IUserRepository;
import com.vti.services.interfaces.IGroupService;

@Service
public class GroupService implements IGroupService{

	private IGroupRepository groupRepository;
	private IUserRepository userRepository;
	public GroupService(IGroupRepository groupRepository, IUserRepository userRepository) {
		this.groupRepository = groupRepository;
		this.userRepository = userRepository;
	}
	@Override
	public boolean insert(GroupModel s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(GroupModel s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Long p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<GroupModel> getById(Long p) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<GroupModel> getAll() {
		return this.groupRepository.findAll();
	}

	@Override
	public boolean addUserToGroup(long groupId, long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUserFromGroup(long groupId, long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<UserModel> getUsersInGroup(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
