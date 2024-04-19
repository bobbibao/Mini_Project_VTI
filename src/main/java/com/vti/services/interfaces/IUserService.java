package com.vti.services.interfaces;

import java.util.Set;

import com.vti.models.GroupModel;
import com.vti.models.UserModel;

public interface IUserService extends IService<UserModel, Long> {
	Set<GroupModel> getGroupsForUser(long userId);
	boolean removeUserFromGroup(long userId, long groupId);
}
