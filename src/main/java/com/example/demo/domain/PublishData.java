package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

public class PublishData {

	public String connectionString;
	public String userName;
	public String password;
	public String destination;
	public String[] messagingTypes;
	public MultipartFile file;
	
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}
