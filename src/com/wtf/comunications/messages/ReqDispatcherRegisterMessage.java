package com.wtf.comunications.messages;




@SuppressWarnings("serial")
public class ReqDispatcherRegisterMessage extends Message {

	public ReqDispatcherRegisterMessage(String thesender, Object rawData) {
		super(thesender, rawData);
		this.setTipoMensaje(TipoMensaje.REQUEST);
	}

	
}
