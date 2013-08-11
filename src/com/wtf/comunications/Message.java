package com.wtf.comunications;

import java.io.Serializable;

public class Message implements Serializable {
	
	private static final long serialVersionUID = -6593570869909632263L;
	public String sender; 
	public String data; 
	public Message  (String thesender, String rawData) { 
	sender = thesender; 
	data  = rawData; 
	}
}
