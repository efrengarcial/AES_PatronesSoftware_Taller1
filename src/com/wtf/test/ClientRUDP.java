package com.wtf.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.wtf.comunications.ReceiverUDP;

public class ClientRUDP implements Observer {

	ReceiverUDP  r; 
	
	public static void main(String[] args) { 
		ExecutorService service = Executors.newFixedThreadPool(10);
		ClientRUDP c = new ClientRUDP();
		byte result[] = null; 
		c.r = new ReceiverUDP("Server") ; 
		c.r.addObserver(c);
		service.submit(c.r);
		//result = c.r. receive ( ) ; 
		 System.out.println("ccccc");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		 System.out.println("\nReceived Response: " + arg1 );
	}
	
	

}
