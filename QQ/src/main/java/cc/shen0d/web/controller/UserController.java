package cc.shen0d.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.shen0d.pojo.entity.User;
import cc.shen0d.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	UserService service;

	@RequestMapping("/getAll.do")
	@ResponseBody
	public List<User> getAll() {
		return service.getAll();
	}
}
