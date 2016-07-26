package com.ecust.activemq.publish;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;
	private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKERURL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageConsumer messageConsumer;
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.USERNAME,
				JMSConsumer.BROKERURL);

		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			// destination = session.createQueue("FirstQ");
			destination = session.createTopic("topic1");
			messageConsumer = session.createConsumer(destination);
			messageConsumer.setMessageListener(new Listener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
