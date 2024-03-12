package myPackage;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.MessageConsumer;
import jakarta.jms.Session;

public class Receiver {
	public static void main(String[] args) throws Exception {
		new Receiver().sendMsg();
	}

	public void sendMsg() throws Exception {
		System.out.println("Listening for message comming....");
		// config environment for JNDI
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		// create context
		Context ctx = new InitialContext(settings);
		// lookup JMS connection factory
		ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
		
		Connection connection = factory.createConnection("admin", "admin");
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination queue = session.createQueue("dynamics/phu");
		
		MessageConsumer reciver = session.createConsumer(queue);
		
		reciver.setMessageListener(message -> {
			System.out.println("----reciver: " + message);
		});
	}
}
