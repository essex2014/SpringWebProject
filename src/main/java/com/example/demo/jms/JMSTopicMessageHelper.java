package com.example.demo.jms;

import javax.annotation.PostConstruct;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Order;
import com.example.demo.domain.PublishData;

@Component
public class JMSTopicMessageHelper implements JMSMessageHelperInt {

	public ActiveMQConnectionFactory connectionFactorty;
	
	@PostConstruct
	public void init() {
		connectionFactorty = new ActiveMQConnectionFactory();
	}
	
	@Override
	public boolean send(PublishData publishData, Order order) {
		try {
	
		connectionFactorty.setBrokerURL(publishData.getConnectionString());
		connectionFactorty.setUserName(publishData.getUserName());
		connectionFactorty.setPassword(publishData.getPassword());
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactorty);
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.convertAndSend(publishData.getDestination(), order);
		return true;
		
		} catch (Exception e) {
			return false;
		} finally {
			
		}
	}

}
