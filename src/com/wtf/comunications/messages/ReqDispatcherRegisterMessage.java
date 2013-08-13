package com.wtf.comunications.messages;



@SuppressWarnings("serial")
public class ReqDispatcherRegisterMessage extends Message {

	private String ipAddress;
	private int port;
	
	public ReqDispatcherRegisterMessage(String thesender, Object rawData) {
		super(thesender, rawData);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
