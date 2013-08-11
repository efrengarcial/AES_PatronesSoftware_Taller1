package com.wtf.test;

import com.wtf.comunications.ForwarderSocketComm;
import com.wtf.comunications.Message;
import com.wtf.comunications.ReceiverSocketComm;

public class Client extends Thread {

	ReceiverSocketComm  r; 
	ForwarderSocketComm f;
	
	public static void main(String[] args) { 
		Client c = new Client();
		byte result[] = null; 
		c.r = new ReceiverSocketComm ("Server") ; 
		result = c.r. receive ( ) ; 
		c.f = new ForwarderSocketComm ("Server") ; 
		Message msg = new Message ("Server","It am alive") ; 
		//f.sendMsg (result. sender, msg) ; 
	}

}
