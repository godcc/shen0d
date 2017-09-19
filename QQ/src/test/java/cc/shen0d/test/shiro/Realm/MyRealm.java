package cc.shen0d.test.shiro.Realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	public String getName() {
		return "myRealm";
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException
	{
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (!"zhang1".equals(userName)) {
			System.out.println("�û�������" + "-----------");
			throw new UnknownAccountException(); // ����û�������
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException(); // ����������
		}
		// ��������֤��֤�ɹ�������һ�� AuthenticationInfo ʵ�֣�
		return new SimpleAuthenticationInfo("123", "666", getName());
	}

}
