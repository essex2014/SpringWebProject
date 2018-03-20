package com.example.demo.jms;

import javax.annotation.PostConstruct;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Order;
import com.example.demo.domain.PublishData;

@Component
public class JMSQueueMessageHelp implements JMSMessageHelperInt {

	public ActiveMQConnectionFactory connectionFactory;
	
	@PostConstruct
	public void init() {
		connectionFactory = new ActiveMQConnectionFactory();
	}
	
	@Override
	public boolean send(PublishData publishData, Order order) {
		try {
	
		connectionFactory.setBrokerURL(publishData.getConnectionString());
		connectionFactory.setUserName(publishData.getUserName());
		connectionFactory.setPassword(publishData.getPassword());
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.convertAndSend(publishData.getDestination(), order);
		return true;
		
		} catch (Exception e) {
			return false;
		} finally {
			
		}
	}

}
