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
import com.wtf.comunications.messages.ReqDispatcherRegistryMessage;

public class Client2   implements Observer {

	static Forwarder forwarder = ForwarderFactory.get();

	public static void main(String[] args) throws IOException { 

		Entry theEntry = new Entry("127.0.0.1", 1000, "TCP");
		RegistrySingleton.getInstance().put("DISPATCHER", theEntry);
		
		//c.f = new ForwarderTCPComm ("Server") ; 
		Message msg = new ReqDispatcherRegistryMessage(Configuration.HOST,"It am alive") ; 
		forwarder.sendMessage("DISPATCHER", msg);
		
		System.out.println("ok.....");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("\nReceived Response: " + arg1 );
	}

}
