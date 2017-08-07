package cc.shen0d.mapper;

import cc.shen0d.pojo.entity.User;

public interface LoginMapper extends BaseMapper<User> {
	public User login(User user);
}
