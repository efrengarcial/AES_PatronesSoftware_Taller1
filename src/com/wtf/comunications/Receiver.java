package com.wtf.comunications;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Receiver implements Observer  {

	
	ReceiverProtocol  r; 
	
	public void receiveMsg () { 
		ExecutorService service = Executors.newFixedThreadPool(10);
		ReceiverProtocol protocol = new ReceiverTCP ("Server") ;
		//http://en.wikipedia.org/wiki/Observer_pattern
		protocol.addObserver(this);
		service.submit(protocol);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Command command = ((Command)arg1);
		command.execute();
	}

}
