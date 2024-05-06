package com.vti.services.implement;

import java.util.List;
import java.util.Map;
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
		Optional<UserModel> userOpt = this.userRepository.findById(userId);
		return userOpt.map(UserModel::getGroups)
				.orElse(null);
	}

	@Override
	public boolean removeUserFromGroup(long userId, long groupId) {
		Optional<UserModel> userOpt = this.userRepository.findById(userId);
		Optional<GroupModel> groupOpt = this.groupRepository.findById(groupId);
		if(!userOpt.isPresent() || !groupOpt.isPresent())
			return false;
		
		UserModel user = userOpt.get();
		GroupModel group = groupOpt.get();
		if(!user.getGroups().remove(group) || !group.getUsers().remove(user))
			return false;
		
		this.userRepository.save(user);
		return true;
	}

	@Override
	public boolean updatePartial(Long p, Map<String, Object> updates) {
		Optional<UserModel> userOpt = this.userRepository.findById(p);
		if(!userOpt.isPresent())
			return false;
		
		UserModel user = userOpt.get();
		
		if(updates.containsKey("username"))
			user.setUsername((String) updates.get("username"));
		if(updates.containsKey("password"))
			user.setPassword((String) updates.get("password"));
		
		this.userRepository.save(user);
		return true;
	}

	@Override
	public boolean deleteMany(List<Long> userIds) {
		this.userRepository.deleteAllById(userIds);
		return true;
	}
}
