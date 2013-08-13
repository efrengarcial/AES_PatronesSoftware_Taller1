package com.wtf.comunications.messages;

@SuppressWarnings("serial")
public class RespDispatcherRegisterMessage extends Message {
	
	private int frecuency ;

	public RespDispatcherRegisterMessage(String thesender, Object rawData) {
		super(thesender, rawData);
	}

	public int getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(int frecuency) {
		this.frecuency = frecuency;
	}
	
}
