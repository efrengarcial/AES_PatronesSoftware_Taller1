package com.wtf.comunications;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverSocketComm implements IComm {
	private ServerSocket srvS; 
	private Socket s; 
	private InputStream iStr; 
	private String myName; 

	public ReceiverSocketComm(String theName) { myName = theName;}
			
	public byte[] receive() {
		int val; 
		byte buffer [] = null; 
		try { 
			//Entry entry = fr.reg.get(myName) ; 
			srvS = new ServerSocket(/*entry.port()*/528, 1000); 
			s = srvS.accept();
			iStr = s.getInputStream(); 
			val = iStr.read () ; 
			buffer = new byte [val] ; 
			iStr.read(buffer) ; 
			iStr.close(); 
			s.close(); 
			srvS.close(); 
		}
		catch(IOException e) {  /*  . . . */ } 
		return buffer; 
	}
}
