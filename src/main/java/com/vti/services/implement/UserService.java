package com.vti.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.repositories.IGroupRepository;
import com.vti.repositories.IUserRepository;
import com.vti.services.interfaces.IUserService;

@Service
public class UserService implements IUserService{

	private IUserRepository userRepository;
	private IGroupRepository groupRepository;
	
	public UserService(IUserRepository userRepository, IGroupRepository groupRepository) {
		super();
		this.userRepository = userRepository;
		this.groupRepository = groupRepository;
	}

	@Override
	public boolean insert(UserModel s) {
		this.userRepository.save(s);
		return true;
	}

	@Override
	public boolean update(UserModel s) {
		if(this.userRepository.existsById(s.getUserId())) {
			this.userRepository.save(s);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(Long p) {
		if(this.userRepository.existsById(p)) {
			this.userRepository.deleteById(p);
			return true;
		}
		return false;
	}

	@Override
	public Optional<UserModel> getById(Long p) {
		return this.userRepository.findById(p);
	}

	@Override
	public List<UserModel> getAll() {
		return this.userRepository.findAll();
	}

	@Override
	public Set<GroupModel> getGroupsForUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUserFromGroup(long userId, long groupId) {
		// TODO Auto-generated method stub
		return false;
	}

}
