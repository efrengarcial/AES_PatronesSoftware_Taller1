package com.wtf.commons;

import com.wtf.comunications.Receiver;
import com.wtf.comunications.ReceiverTCPComm;

public class ReceiverFactory {

	public static Receiver get(){
		if (Configuration.PROTOCOL.equals("TCP")) {
			return new ReceiverTCPComm();
		} else {
			//return new ReceiverUDPComm();
		}
		return null;
	}

}
