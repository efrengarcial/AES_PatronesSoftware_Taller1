package com.wtf.comunications;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ForwarderTCPComm {
	private Socket s; 
	private OutputStream oStr; 
	private String myName; 
	public ForwarderTCPComm(String theName) { 
		myName = theName ;
	}
	private  byte []  marshal (/*Message theMsg*/) { 
		/*  . . . */ 
		return null; 
	}
	
	public  byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	
	 private void deliver(String theDest, byte[] data) { 
		try {
			//Entry entry = fr.reg.get (theDest1  ;
			s = new Socket(/*entry.dest0*/"localhost", 528/*entry.port()*/); 
			oStr = s.getOutputStream() ; 
			oStr.write(data); 
			oStr.flush(); 
			oStr.close(); 
			s.close(); 
			
		} catch(IOException e) { 
			e.printStackTrace();
		} 
	}
	
	public void sendMsg (String  theDest ,Message theMsg) throws IOException { 
		deliver(theDest, serialize(theMsg) ) ;
	}
}