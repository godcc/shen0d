package cc.shen0d.web.WebService.enpoint;

import javax.xml.ws.Endpoint;

import cc.shen0d.pojo.entity.WebServiceTest;

public class WebServiceEnpoint implements IWebServiceEnpoint {

	public WebServiceTest getWebServiceTest(String name, String password) {
		System.out.println(name);
		return new WebServiceTest(name, password);
	}

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9090/ws", new WebServiceEnpoint());
	}
}
