package com.wtf.test;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.wtf.comunications.ForwarderTCPComm;
import com.wtf.comunications.ReceiverTCPComm;

public class Client   implements Observer {

	ReceiverTCPComm  r; 
	ForwarderTCPComm f;
	
	public static void main(String[] args) { 
		ExecutorService service = Executors.newFixedThreadPool(10);
		Client c = new Client();
		byte result[] = null; 
		c.r = new ReceiverTCPComm ("Server") ; 
		c.r.addObserver(c);
		service.submit(c.r);
		//result = c.r. receive ( ) ; 
		 System.out.println("ccccc");
		
		
		/*c.f = new ForwarderSocketComm ("Server") ; 
		Message msg = new Message ("Server","It am alive") ; 
		//f.sendMsg (result. sender, msg) ;
		c.f.deliver("Server", new byte[]{125,58});*/
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		 System.out.println("\nReceived Response: " + arg1 );
	}

}
