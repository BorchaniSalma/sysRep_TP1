package tp_repartie;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {
private static final String EXCHANGE_NAME = "direct_logs";

public static void main(String[] argv) throws Exception {
	ConnectionFactory factory = new ConnectionFactory();
	factory.setHost("localhost");
try (Connection connection = factory.newConnection();
		Channel channel = connection.createChannel()) {
	channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
	
String severity = getSeverity(argv);
String message = getMessage(argv);

channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));

System.out.println("[x] Sent '"+ severity + "':'"+ message + "'");

}
}

private static String getMessage(String[] argv) {
	// TODO Auto-generated method stub
	return argv[0];
}

private static String getSeverity(String[] argv) {
	return argv[1];
}
}
