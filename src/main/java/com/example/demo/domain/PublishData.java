package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

public class PublishData {

	public String connectionString;
	public String userName;
	public String password;
	public String destination;
	public String[] messagingTypes;
	public MultipartFile orderFile;
	
	public MultipartFile getOrderFile() {
		return orderFile;
	}
	public void setOrderFile(MultipartFile orderFile) {
		this.orderFile = orderFile;
	}
	public String getConnectionString() {
		return connectionString;
	}
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String[] getMessagingTypes() {
		return messagingTypes;
	}
	public void setMessagingTypes(String[] messagingTypes) {
		this.messagingTypes = messagingTypes;
	}
	
	
	
	
}
