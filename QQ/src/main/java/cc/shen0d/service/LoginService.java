package cc.shen0d.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.shen0d.mapper.LoginMapper;
import cc.shen0d.pojo.entity.User;

/**
 * µÇÂ¼service
 * 
 * @author sihan
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginMapper loginMapper;

	public User login(User user) {
		System.out.println(loginMapper);

		return loginMapper.login(user);
	}

}
