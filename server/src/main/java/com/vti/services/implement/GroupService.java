package com.vti.services.implement;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
		this.groupRepository.save(s);
		return true;
	}

	@Override
	public boolean update(GroupModel s) {
		if(this.groupRepository.existsById(s.getGroupId())) {
			this.groupRepository.save(s);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(Long p) {
		if(this.groupRepository.existsById(p)) {
			this.groupRepository.deleteById(p);
			return true;
		}
		return false;
	}

	@Override
	public Optional<GroupModel> getById(Long p) {
		Optional<GroupModel> groupOpt = this.groupRepository.findById(p);
		return groupOpt;
	}

	@Override
	public List<GroupModel> getAll() {
		return this.groupRepository.findAll();
	}

	@Override
	public boolean addUserToGroup(long groupId, long userId) {
		Optional<GroupModel> groupOpt = this.groupRepository.findById(groupId);
		Optional<UserModel> userOpt = this.userRepository.findById(userId);
		if(groupOpt.isPresent() && userOpt.isPresent()) {
			GroupModel group = groupOpt.get();
			UserModel user = userOpt.get();
			if(group.getUsers().add(user) && user.getGroups().add(group)) {
				this.groupRepository.save(group);
				return true;
			}
		}
			
		return false;
	}

	@Override
	public boolean removeUserFromGroup(long groupId, long userId) {
		Optional<GroupModel> groupOpt = this.groupRepository.findById(groupId);
		Optional<UserModel> userOpt = this.userRepository.findById(userId);
		if(groupOpt.isPresent() && userOpt.isPresent()) {
			GroupModel group = groupOpt.get();
			UserModel user = userOpt.get();
			if(group.getUsers().remove(user) && user.getGroups().remove(group)) {
				this.groupRepository.save(group);
				return true;
			}
		}
			
		return false;
	}

	@Override
	public Set<UserModel> getUsersInGroup(long groupId) {
		Optional<GroupModel> groupOpt = this.groupRepository.findById(groupId);
		return groupOpt.map(GroupModel::getUsers)
				.orElse(null);
	}
	
	@Override
	public boolean updatePartial(Long p, Map<String, Object> updates) {
		GroupModel group = this.groupRepository.findById(p).orElse(null);
		if(Objects.isNull(group)) {
			return false;
		}
		
		updates.forEach((key, value) -> {
			switch(key) {
				case "groupName":
					group.setGroupName((String) value);
					break;
				
				default:
					break;
			}
		});
		
		this.groupRepository.save(group);
		return true;
	}
	@Override
	public boolean deleteMany(List<Long> userIds) {
		// TODO Auto-generated method stub
		return false;
	}

}
