package myPackage;

import jakarta.jms.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class Sender {
    public static void main(String[] args) throws Exception {
        new Sender().sendMsg("Chao cau nha");
    }

    public void sendMsg(String msg) throws Exception{
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

        //create producer
        MessageProducer producer = session.createProducer(queue);

        //create text message
        Message message = session.createTextMessage(msg);
        producer.send(message);

        //shutdown connection
        session.close();
        connection.close();
        System.out.println("Finished...");


    }
}
