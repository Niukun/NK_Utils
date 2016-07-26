package com.ecust.activemq.publish;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * 
 * 消息监听
 * @author Niukun
 *
 */
public class Listener2 implements MessageListener{

	public void onMessage(Message message) {
		try {
			System.out.println("订阅者2收到的消息：" +((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
