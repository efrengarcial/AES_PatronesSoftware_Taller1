package com.wtf.test;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.wtf.comunications.ForwarderTCPComm;
import com.wtf.comunications.Message;

public class Client2   implements Observer {

	ForwarderTCPComm f;

	public static void main(String[] args) throws IOException { 
		Client2 c = new Client2();

	
		c.f = new ForwarderTCPComm ("Server") ; 
		Message msg = new Message ("Server","It am alive") ; 
		//f.sendMsg (result. sender, msg) ;
		c.f.sendMsg("Server", msg);
		System.out.println("ok.....");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("\nReceived Response: " + arg1 );
	}

}
