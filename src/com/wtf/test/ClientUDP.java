package com.wtf.test;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.wtf.comunications.ForwarderUDP;
import com.wtf.comunications.Message;
import com.wtf.comunications.RequestDispatcherMessage;

public class ClientUDP   implements Observer {

	ForwarderUDP f;

	public static void main(String[] args) throws IOException { 
		ClientUDP c = new ClientUDP();

	
		c.f = new ForwarderUDP ("localhost",9876) ; 
		Message msg = new RequestDispatcherMessage ("Server","It am alive efl12345") ; 
		//f.sendMsg (result. sender, msg) ;
		c.f.deliver(msg);
		System.out.println("ok.....");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("\nReceived Response: " + arg1 );
	}

}
