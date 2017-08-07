package cc.shen0d.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.shen0d.pojo.entity.User;

/**
 * ×¢²áÀà
 * 
 * @author sihan
 *
 */
@Controller
public class RegisterController {

	@RequestMapping("/register.do")
	public Map<String, Object> register(@RequestBody User user) {

		return null;
	}

}
