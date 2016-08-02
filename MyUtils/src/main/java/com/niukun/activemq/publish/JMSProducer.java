package com.niukun.activemq.publish;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @author Niukun
 *
 */
public class JMSProducer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	@SuppressWarnings("unused")
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKERURL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	private static final int SENDNUM = 10;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageProducer messageProducer;

		connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.USERNAME,
				JMSProducer.BROKERURL);
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//			destination = session.createQueue("FirstQ");
			destination = session.createTopic("topic1");
			messageProducer = session.createProducer(destination);
			sendMessage(session, messageProducer);
			session.commit();
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void sendMessage(Session session, MessageProducer messageProducer) {
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
			try {
				TextMessage message = session.createTextMessage("AQ send" + i);
				System.out.println("The message snet " + i);
				messageProducer.send(message);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
