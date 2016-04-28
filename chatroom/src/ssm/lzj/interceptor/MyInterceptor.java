package ssm.lzj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor
{
	//自定义的拦截器需要实现org.springframework.web.servlet.HandlerInterceptor接口
	//这个是在Controllter对应的方法执行之后执行，
	//可以做一些统一的异常，日志的处理。
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	//这个方法是在Controller对应的方法执行之后，ModelAndView返回之前
	//可以做一些统一的页面返回配送
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	//它的执行时机是，在拦截范围内的Controller方法执行之前。
	//这个方法我们可以做一些登录校验，身份验证，权限验证等准备工作，返回值为true为放行。
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception
	{
		System.out.println("in interceptor"+request.getSession().getAttribute("username"));
		if(request.getSession().getAttribute("username")!=null)
		return true;
		response.sendRedirect("http://localhost:8080/springmvc_spring3.2_mybatis/toLogin.action");
		return false;
		
	}
}
