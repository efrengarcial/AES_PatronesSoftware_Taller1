package com.wtf.test;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.wtf.commons.Configuration;
import com.wtf.commons.Entry;
import com.wtf.commons.ForwarderFactory;
import com.wtf.commons.RegistrySingleton;
import com.wtf.comunications.Forwarder;
import com.wtf.comunications.messages.Message;
import com.wtf.comunications.messages.ReqDispatcherRegisterMessage;

public class Client2   {

	static Forwarder forwarder = ForwarderFactory.get();

	public static void main(String[] args) throws IOException { 

		Entry theEntry = new Entry("127.0.0.1", 1000, "TCP");
		RegistrySingleton.getInstance().put("DISPATCHER", theEntry);
		
		//c.f = new ForwarderTCPComm ("Server") ; 
		Message msg = new ReqDispatcherRegisterMessage(Configuration.lOCALHOST,"Estoy registrandome...") ; 
		forwarder.sendMessage("DISPATCHER", msg);
		
	}
	
}
