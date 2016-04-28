package ssm.lzj.exception;

public class MyException extends Exception
{
	private String exceptionMessage;
	public MyException(String message)
	{
		this.exceptionMessage=message;
	}
	public String getExceptionMessage()
	{
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage)
	{
		this.exceptionMessage = exceptionMessage;
	}
	
}
