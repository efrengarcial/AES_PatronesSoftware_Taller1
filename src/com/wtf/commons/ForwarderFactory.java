package com.wtf.commons;

import com.wtf.comunications.Forwarder;
import com.wtf.comunications.ForwarderTCPComm;
import com.wtf.comunications.ForwarderUDPComm;

public class ForwarderFactory {

	public static Forwarder get(int port , String protocol){
		if (protocol.equals("TCP")) {
			return new ForwarderTCPComm();
		} else {
			return new ForwarderUDPComm();
		}
	}
}
