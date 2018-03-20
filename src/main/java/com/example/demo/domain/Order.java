package com.example.demo.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order")
public class Order implements Serializable{

	public String accont;
	public String submittedAt;
	public String receivedAt	;
	public String market;
	public String action;
	public int size;
	public String getAccont() {
		return accont;
	}
	public void setAccont(String accont) {
		this.accont = accont;
	}
	public String getSubmittedAt() {
		return submittedAt;
	}
	public void setSubmittedAt(String submittedAt) {
		this.submittedAt = submittedAt;
	}
	public String getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Order(String accont, String submittedAt, String receivedAt, String market, String action, int size) {
		super();
		this.accont = accont;
		this.submittedAt = submittedAt;
		this.receivedAt = receivedAt;
		this.market = market;
		this.action = action;
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accont == null) ? 0 : accont.hashCode());
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((market == null) ? 0 : market.hashCode());
		result = prime * result + ((receivedAt == null) ? 0 : receivedAt.hashCode());
		result = prime * result + size;
		result = prime * result + ((submittedAt == null) ? 0 : submittedAt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (accont == null) {
			if (other.accont != null)
				return false;
		} else if (!accont.equals(other.accont))
			return false;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (receivedAt == null) {
			if (other.receivedAt != null)
				return false;
		} else if (!receivedAt.equals(other.receivedAt))
			return false;
		if (size != other.size)
			return false;
		if (submittedAt == null) {
			if (other.submittedAt != null)
				return false;
		} else if (!submittedAt.equals(other.submittedAt))
			return false;
		return true;
	}
	
	
	
	
}
