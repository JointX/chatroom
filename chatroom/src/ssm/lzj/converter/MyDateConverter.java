package ssm.lzj.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date>
{
	//我们自动一的类型转换需要实现converter转换器
	public Date convert(String source)
	{
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			
			return simpleDateFormat.parse(source);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		//转换失败则返回空
		return null;
	}

}
