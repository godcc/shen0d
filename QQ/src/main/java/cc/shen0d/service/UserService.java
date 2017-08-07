package cc.shen0d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.shen0d.mapper.UserMapper;
import cc.shen0d.pojo.entity.User;

@Service
public class UserService {

	@Autowired
	UserMapper mapper;

	public List<User> getAll() {
		return mapper.getAll();
	}

}
