package ssm.lzj.handler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.lzj.pojo.Roles;
import ssm.lzj.pojo.User;

@Controller
public class Login
{
	@RequestMapping("/toLogin")
	@RequiresRoles("guest")
	public String toLogin()
	{
		return "login";
	}
	@RequestMapping("/login")
	public String login(User user)
	{
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
				user.getPassword());
		try
		{
			SecurityUtils.getSubject().login(token);

		}
		catch (AuthenticationException e)
		{
			return "login";
		}
		return "loginSuccess";
	}
	public User loginCheck(String username)
	{
		return null;
	}
	public User getById(Integer userId)
	{
		return null;
	}
	public Roles getByRoleId(String rid)
	{
		return null;
	}
}
