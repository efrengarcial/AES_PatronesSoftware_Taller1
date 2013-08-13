package com.wtf.comunications;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.wtf.comunications.messages.Message;

public abstract class Receiver {

	
	public Message unmarshal(byte[] data) {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(in);
			return (Message)is.readObject();
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}

	public Message receiveMessage() throws Exception {
		byte[] messageBytes = receive();
		return unmarshal(messageBytes);
	}

	public abstract byte[] receive();

}
