package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Order;
import com.example.demo.domain.PublishData;
import com.example.demo.jms.JMSQueueMessageHelp;
import com.example.demo.jms.JMSTopicMessageHelper;
import com.example.demo.utils.XMLConverter;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@Resource
	XMLConverter xmlConverter;
	
	@Autowired
	JMSQueueMessageHelp jmsQueueMessageHelper;
	
	@Autowired
	JMSTopicMessageHelper jmsTopicMessageHelper;
	
	@GetMapping("/")
    public String homePage(Model model) {
        return "publisher";
    }
	
	@PostMapping("/publish")
	public String doRegister(@ModelAttribute PublishData formData,ModelMap map,HttpSession session) {
		try {
			//Validate the input values entered by user
			if (formData.getOrderFile().isEmpty()) {
				logger.error("Invalid file uploaded by user");
				return "failure";
			}
			if (formData.getDestination().isEmpty()) {
				logger.error("Invalid destination entered by user");
				return "failure";
			}
			if (formData.getConnectionString().isEmpty()) {
				logger.error("Invalid connection string entered by user");
				return "failure";
			}
			
			String is = new String(formData.getOrderFile().getBytes());
			String lines[] = StringUtils.split(is,System.lineSeparator());
			for (int i = 1; i < lines.length; i++) {
				Order order = (Order)xmlConverter.convertFromXMLToObject(lines[i]);
				send(formData,order);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
	
	public boolean send(PublishData publishData,Order order) {
		try {
			String[] messagingType = publishData.getMessagingTypes();
			for (int i = 0; i < messagingType.length; i++) {
				if (messagingType[i].equalsIgnoreCase("queue")) {
					return jmsQueueMessageHelper.send(publishData, order);
				} else if (messagingType[i].equalsIgnoreCase("topic")) {
					return jmsTopicMessageHelper.send(publishData, order);
				}
				
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return false;
		}
	}
	
}
