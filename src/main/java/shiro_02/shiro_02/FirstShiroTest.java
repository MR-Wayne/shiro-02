package shiro_02.shiro_02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class FirstShiroTest {

	public void testHelloWorld() {
		// 根據配置文件初始化SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		// 得到SecurityManager實例
		SecurityManager securityManager = factory.getInstance();
		// 将得到的实例绑定给SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到subject
		Subject subject = SecurityUtils.getSubject();
		// 创建用户名密码身份验证Token
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			// 登陆
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			// 登陆失败
		}
		//检查用户是否已经登陆
		System.out.println(subject.isAuthenticated());
		subject.logout();

	}
	public static void main(String[] args) {
		new FirstShiroTest().testHelloWorld();
	}
}
