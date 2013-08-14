package com.wtf.commons;

import com.wtf.comunications.Receiver;
import com.wtf.comunications.ReceiverTCPComm;
import com.wtf.comunications.ReceiverUDPComm;

public class ReceiverFactory {

	public static Receiver get(int port , String protocol){
		if (protocol.equals("TCP")) {
			return new ReceiverTCPComm(port);
		} else {
			return new ReceiverUDPComm(port);
		}
	}

}
