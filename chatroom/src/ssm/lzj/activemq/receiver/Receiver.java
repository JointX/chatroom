package ssm.lzj.activemq.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver
{
	public static void main(String[] args)
	{
		
		ConnectionFactory connectionFactory;//jms连接工厂
		Connection connection=null;//jsm连接
		Session session;//一个发送或接受消息的线程
		Destination destination;//消息的目的地或者发送
		MessageConsumer messageConsumer;//消息接受者
		
		connectionFactory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://localhost:61616");
		try
		{
			connection=connectionFactory.createConnection();//得到connection
			connection.start();//开启连接
			session=connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			
			destination=session.createQueue("FirstQueues");//获取服务
			messageConsumer=session.createConsumer(destination);
			
			while(true)
			{
				TextMessage message=(TextMessage)messageConsumer.receive(5000000);
				if(null!=message)
				{
					System.out.println("收到消息"+message.getText());
				}
				else
				{
					break;
				}
			}
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
}
