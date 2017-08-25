package cc.shen0d.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.shen0d.web.WebService.client.IWebServiceEnpoint;
import cc.shen0d.web.WebService.client.WebServiceTest;

@Controller
public class Test {

	@Autowired
	IWebServiceEnpoint bean;

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		// return enpoint.getWebServiceTest("张三", "李四");
		WebServiceTest webServiceTest = bean.getWebServiceTest("123", "555");
		return webServiceTest.toString();
	}

}
