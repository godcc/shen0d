package cc.shen0d.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.shen0d.web.WebService.client.WebServiceEnpoint;
import cc.shen0d.web.WebService.client.WebServiceTest;

@Controller
public class Test {

	@Autowired
	@Qualifier("webServiceClient")
	private WebServiceEnpoint enpoint;

	@RequestMapping("/test")
	@ResponseBody
	public WebServiceTest test() {
		return enpoint.getWebServiceTest("张三", "李四");
	}

}
