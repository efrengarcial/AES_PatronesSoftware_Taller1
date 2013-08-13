package com.wtf.test;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.wtf.comunications.ForwarderTCPComm;
import com.wtf.comunications.IReceiverComm;

public class Client   implements Observer {

	IReceiverComm  r; 
	ForwarderTCPComm f;

	public static void main(String[] args) throws IOException { 
		ExecutorService service = Executors.newFixedThreadPool(10);
		Client c = new Client();
		byte result[] = null; 
		//c.r = new ReceiverTCPComm ("Server") ;
		//http://en.wikipedia.org/wiki/Observer_pattern
		//c.r.addObserver(c);
		service.submit(c.r);
		//result = c.r. receive ( ) ; 
	
		/*c.f = new ForwarderTCPComm ("Server") ; 
		Message msg = new Message ("Server","It am alive") ; 
		//f.sendMsg (result. sender, msg) ;
		c.f.sendMsg("Server", msg);
		System.out.println("ok.....");*/
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("\nReceived Response: " + arg1 );
	}

}
