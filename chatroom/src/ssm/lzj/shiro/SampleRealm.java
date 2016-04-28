package ssm.lzj.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ssm.lzj.handler.Login;
import ssm.lzj.pojo.Roles;
import ssm.lzj.pojo.User;


@Component
public class SampleRealm extends AuthorizingRealm
{
	
	@Autowired(required=true)
	private Login login;
	public SampleRealm()
	{
		setName("SampleRealm");
		// This name must match the name in the User class's getPrincipals()
		// method
		// setCredentialsMatcher(new Sha256CredentialsMatcher());
		setCredentialsMatcher(new AllowAllCredentialsMatcher());
	}
	public boolean supports(AuthenticationToken token)
	{
		//
		return super.supports(token);
	}

	// 认证信息，主要针对用户登录，（下文讲述在action或者controller登录过程代码）
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		//令牌中取出用户密码
		String password = String.valueOf(token.getPassword());
		//调用操作数据库的方法查询user信息,作自定义的验证
		String username=(String)token.getPrincipal();
		
		User user = login.loginCheck(username);
		if (user!= null)
		{
			if (password.equals(user.getPassword()))
			{
				Session session = SecurityUtils.getSubject().getSession();
				session.setAttribute("username", user.getUsername());
				return new SimpleAuthenticationInfo(user.getUid(),
						user.getPassword(), getName());
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	//给验证框架加载用户信息和角色信息，如果有缓存的情况下只加载一次。
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals)
	{
		//这一步是获取
		Integer userId = (Integer) principals.fromRealm(getName()).iterator()
				.next();
		User user = login.getById(userId);
		if (user != null)
		{
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			Roles role = login.getByRoleId(user.getRid());
			//添加角色
			info.addRole(role.getRoleName());
			//如果你添加了对权限的表，打开此注释，添加角色具有的权限
			info.addStringPermission("admin:a");

			return info;
		}
		else
		{
			return null;
		}
	}

}
