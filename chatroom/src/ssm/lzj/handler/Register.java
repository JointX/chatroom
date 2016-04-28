package ssm.lzj.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.lzj.pojo.User;

@Controller
public class Register
{
	@RequestMapping("/toRegister")
	public String toRegister()
	{
		return "register";
	}
	@RequestMapping("/register")
	public String register(User user,HttpSession session)
	{
		if (user.getUsername()!= null || user.getPassword() != null||user.getEmail()!=null)
		{
			return "loginSuccess";
		}
		session.setAttribute("username", user.getUsername());
		session.setAttribute("password", user.getPassword());
		return "register";
	}
}
