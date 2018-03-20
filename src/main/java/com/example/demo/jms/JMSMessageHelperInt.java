package com.example.demo.jms;

import com.example.demo.domain.Order;
import com.example.demo.domain.PublishData;

public interface JMSMessageHelperInt {

	public boolean send(PublishData publishData,Order order);
}
