package shiro_02.shiro_02;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class Myrealm1 implements Realm {

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		if(!"zhang".equals(username)){
			throw new UnknownAccountException();
		}
		
		return new SimpleAuthenticationInfo(username+"Myrealm1", password, getName());
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "my realm 1";
	}

	public boolean supports(AuthenticationToken authenticationToken) {
		// TODO Auto-generated method stub
		return authenticationToken instanceof UsernamePasswordToken;
	}
}
