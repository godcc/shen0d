package cc.shen0d.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("/test")
	public String test() {
		System.out.println(123);
		return "123";
	}

}
