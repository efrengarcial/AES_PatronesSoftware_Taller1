package com.wtf.comunications;

import java.io.Serializable;

public abstract class Message implements Serializable {

	private static final long serialVersionUID = -6593570869909632263L;
	public String sender; 
	public Object data; 
	public Message  (String thesender, Object rawData) { 
		sender = thesender; 
		data  = rawData; 
	}
	
}
