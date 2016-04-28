package ssm.lzj.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver
{
	//自定义异常处理，可以判断异常出现的位置，类型，以及哪个模块，当然也可以作为校验来用。	
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
	{
		MyException me=null;
		ModelAndView mv=new ModelAndView();
		if(arg3 instanceof MyException)
		{
			me=(MyException) arg3;
			mv.addObject("exceptionMessage", me.getExceptionMessage());
			mv.setViewName("error");
			System.out.println(arg3.getMessage());
			return mv;
		}
		else
		{
			System.out.println(arg3.getMessage());
			mv.addObject("exceptionMessage", "未知错误:"+System.currentTimeMillis());
			mv.setViewName("error");
		}
		return mv;
	}

}
