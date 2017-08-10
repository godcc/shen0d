package cc.shen0d.web.WebService.enpoint;

import javax.jws.WebParam;
import javax.jws.WebService;

import cc.shen0d.pojo.entity.WebServiceTest;

@WebService
public interface IWebServiceEnpoint {

	public WebServiceTest getWebServiceTest(@WebParam(name = "name") String name,
			@WebParam(name = "password") String password);

}
