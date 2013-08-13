package com.wtf.commons;

import com.wtf.comunications.Forwarder;
import com.wtf.comunications.ForwarderTCPComm;

public class ForwarderFactory {

	public static Forwarder get(){
		if (Configuration.PROTOCOL.equals("TCP")) {
			return new ForwarderTCPComm();
		} else {
			//return new ReceiverUDPComm();
		}
		return null;
	}

}
