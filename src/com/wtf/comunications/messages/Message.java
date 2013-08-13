package com.wtf.comunications.messages;

import java.io.Serializable;

public abstract class Message implements Serializable {

	private static final long serialVersionUID = -6593570869909632263L;
	private String sender; 
	private Object data; 
	
	public Message  (String thesender, Object rawData) { 
		setSender(thesender); 
		setData(rawData); 
	}
	

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
