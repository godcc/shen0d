package cc.shen0d.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.Before;
import org.junit.Test;

public class ShiroTest {

	@Test
	public void testShiroHelloWorld() {
		// 通过配置文件创建安全管理器工厂
		IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory(
				"classpath:shiro.ini");
		/**
		 * 获取安全管理器
		 */
		SecurityManager instance = iniSecurityManagerFactory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken passwordToken = new UsernamePasswordToken("zhang", "123", "8080");
		try {
			subject.login(passwordToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean authenticated = subject.isAuthenticated();
		System.out.println(subject.getSession().getHost());
		subject.logout();

	}

	@Test
	public void testJdbcRealm() {
		System.out.println("------------");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_jdbc.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object principal = subject.getPrincipal();
		System.out.println(principal);
		boolean authenticated = subject.isAuthenticated();
		System.out.println(authenticated);
		subject.logout();

	}

	@Test
	public void testShiroRole() {
		login("classpath:shiro_role.ini");

	}

	public void login(String fileName) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(fileName);
		SecurityManager instance = factory.getInstance();
		SecurityUtils.setSecurityManager(instance);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		boolean authenticated = subject.isAuthenticated();
		subject.checkRole("admin");
		System.out.println();

	}

	@Before
	public void logout() {
		ThreadContext.unbindSubject();
	}
}
