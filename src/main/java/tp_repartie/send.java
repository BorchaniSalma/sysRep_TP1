package tp_repartie;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class send {
	private final static String QUEUE_NAME = "hello";
	public static void main(String[] args) throws Exception {
		ConnectionFactory f = new ConnectionFactory();
		f.setHost("localhost");
		
		try 
		{
			Connection connection = f.newConnection();
			Channel channel = connection.createChannel();
			channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			String message = "Hello World !!";
			channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
			System.out.println("[x] Sent '" + message + "'");
		}
		finally{
			System.out.println("termine");
		}
	}
}
