package com.wtf.comunications;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ForwarderSocketComm {
	private Socket s; 
	private OutputStream oStr; 
	private String myName; 
	public ForwarderSocketComm(String theName) { 
		myName = theName ;
	}
	private  byte []  marshal (/*Message theMsg*/) { 
		/*  . . . */ 
		return null; 
	}
	
	public void deliver(String theDest, byte[] data) { 
		try {
			//Entry entry = fr.reg.get (theDest1  ;
			s = new Socket(/*entry.dest0*/"loalhost", 528/*entry.port()*/); 
			oStr = s.getOutputStream() ; 
			oStr.write(data); 
			oStr.flush(); 
			oStr.close(); 
			s.close(); 
			
		} catch(IOException e) { /*  . . . */ } 
				
	}
}