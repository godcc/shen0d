package cc.shen0d.web.WebService.client;

public class Test1 {
	// JaxWsProxyFactoryBean
	public static void main(String[] args) {
		WebServiceEnpoint webServiceEnpointPort = new WebServiceEnpointService()
				.getWebServiceEnpointPort();
		WebServiceTest webServiceTest = webServiceEnpointPort.getWebServiceTest("123", "555");
		System.out.println(webServiceTest);
	}

}
