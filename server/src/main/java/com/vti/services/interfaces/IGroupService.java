package com.vti.services.interfaces;

import java.util.Set;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;

public interface IGroupService extends IService<GroupModel, Long>{
	boolean addUserToGroup(long groupId, long userId);
	boolean removeUserFromGroup(long groupId, long userId);
	Set<UserModel> getUsersInGroup(long groupId);
}
