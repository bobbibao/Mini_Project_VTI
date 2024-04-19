package com.vti.services.implement;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;
import com.vti.services.interfaces.IUserService;

@Service
public class UserService implements IUserService{

	@Override
	public boolean insert(UserModel s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserModel s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Long p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<UserModel> getById(Long p) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return null;
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
