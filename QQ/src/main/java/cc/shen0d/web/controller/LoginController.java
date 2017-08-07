package cc.shen0d.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.shen0d.pojo.entity.User;
import cc.shen0d.service.LoginService;

/**
 * ��¼controller
 * 
 * @author sihan
 *
 */
@Controller
public class LoginController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	LoginService loginService;

	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String, Object> login(@RequestBody User user, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		User login = loginService.login(user);
		if (login == null) {
			map.put("msg", "�˻������ڻ��������");
		} else {
			request.getSession().setAttribute("user", login);
			map.put("msg", "��¼�ɹ�");
		}
		logger.info("123");
		return map;
	}

}
