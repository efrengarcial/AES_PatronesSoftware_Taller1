package com.wtf.comunications.messages;


@SuppressWarnings("serial")
public class ReqDispatcherRegistryMessage extends Message {

	public ReqDispatcherRegistryMessage(String thesender, Object rawData) {
		super(thesender, rawData);
		this.setTipoMensaje(TipoMensaje.REQUEST);
	}

}
