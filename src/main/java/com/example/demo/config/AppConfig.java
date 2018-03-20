package com.example.demo.config;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.example.demo.utils.XMLConverter;

@Configuration
public class AppConfig {

	@Resource
	ConfigurableApplicationContext appContext;
	
	@Bean 
	XMLConverter xmlConverter(){
		XMLConverter xmlConverter = new XMLConverter();
		xmlConverter.setMarshaller(marshaller());
		xmlConverter.setUnmarshaller(marshaller());
		return xmlConverter;
	}
	
	@Bean
	public Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(com.example.demo.domain.Order.class);
		return marshaller;
	}
	
}
