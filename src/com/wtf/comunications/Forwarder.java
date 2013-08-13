package com.wtf.comunications;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.wtf.comunications.messages.Message;

public abstract class Forwarder {
	 
		
	public  byte[] marshal(Message obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	
	public void sendMessage(String theDest,Message message) throws IOException {
		byte[] messageBytes = marshal(message);
		deliver(theDest, messageBytes);
	}
	
	public abstract void deliver(String theDest , byte[] messageBytes);
	
}
