package com.wtf.commons;

import java.io.Serializable;

public class Entry implements Serializable { 

	private static final long serialVersionUID = 1503636072155317114L;
	private String destinationId; // target machine 
	private int  portNr; // port 
	private String protocol;

	public Entry(String  theDest, int theport, String protocol) { 
		setDestinationId(theDest); 
		setPortNr(theport); 
		this.protocol = protocol;
	}
	
	public String getProtocolo() {
		return protocol;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public int getPortNr() {
		return portNr;
	}

	public void setPortNr(int portNr) {
		this.portNr = portNr;
	}
	
}