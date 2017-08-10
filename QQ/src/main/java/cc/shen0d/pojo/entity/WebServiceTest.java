package cc.shen0d.pojo.entity;

import java.io.Serializable;

public class WebServiceTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebServiceTest() {
	}

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WebServiceTest(String name, String password) {
		this.name = name;
		this.password = password;
	}

}
