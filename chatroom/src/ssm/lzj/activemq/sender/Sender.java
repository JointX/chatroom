package ssm.lzj.activemq.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ServerSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender
{
	public static final int SEND_NUMBER = 10;

	public static void main(String[] args)
	{
		
		ConnectionFactory connectionFactory;//jms连接工厂
		Connection connection=null;//jsm连接
		Session session;//一个发送或接受消息的线程
		Destination destination;//消息的目的地或者发送
		MessageProducer messageProducer;//消息发送者
		
		connectionFactory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");
		try
		{
			connection=connectionFactory.createConnection();//得到connection
			connection.start();//开启连接
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination=session.createQueue("FirstQueues");//获取服务
			messageProducer=session.createProducer(destination);//得到消息生产者
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//设置不持久化
			sendMessage(session,messageProducer);
			session.commit();
			
					
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void sendMessage(Session session,MessageProducer messageProducer)
	{
		for(int i=0;i<SEND_NUMBER;i++)
		{
			try
			{
				TextMessage message=session.createTextMessage("Active发送的小小:"+i);
				System.out.println("Active发送的小小:"+i);
				messageProducer.send(message);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
