package com.wtf.comunications.messages;


@SuppressWarnings("serial")
public class RespDispatcherRegistryMessage extends Message {

	public RespDispatcherRegistryMessage(String thesender, Object rawData) {
		super(thesender, rawData);
		this.setTipoMensaje(TipoMensaje.RESPONSE);
	}
}
