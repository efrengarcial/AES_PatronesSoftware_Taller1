package com.wtf.test;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.wtf.comunications.ForwarderTCPComm;
import com.wtf.comunications.IReceiverComm;

public class Client   implements Observer {

	IReceiverComm  r; 
	ForwarderTCPComm f;

	public static void main(String[] args) throws IOException { 
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("\nReceived Response: " + arg1 );
	}

}
