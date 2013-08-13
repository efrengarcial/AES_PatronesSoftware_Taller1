package com.wtf.comunications;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import com.wtf.commons.Entry;
import com.wtf.commons.RegistrySingleton;

public class ForwarderTCPComm  extends  Forwarder{
	private Socket s; 
	private OutputStream oStr; 

	
	public void deliver(String theDest,byte[] data) {
		try {
			Entry entry = RegistrySingleton.getInstance().get (theDest) ;
			System.out.println("Enviando mensaje al host: "+ entry.getDestinationId() + ", por el puerto: "+entry.getPortNr() );
			s = new Socket(entry.getDestinationId(),entry.getPortNr()); 
			oStr = s.getOutputStream() ; 
			oStr.write(data); 
			oStr.flush(); 
			oStr.close(); 
			s.close(); 

		} catch(IOException e) { 
			e.printStackTrace();
		} 
	}


}