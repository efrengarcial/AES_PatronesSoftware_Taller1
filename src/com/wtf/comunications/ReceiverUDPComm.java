package com.wtf.comunications;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Observable;

public class ReceiverUDPComm extends Observable  implements IReceiverComm {
	private DatagramSocket listener ; 
	private String myName; 

	public ReceiverUDPComm(String theName) { 
		myName = theName;
	}

	private Object unmarshall(byte[] data) {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(in);
			return is.readObject();
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}

	@Override
	public void run()  {
		receive();
	}

	private void receive() {
		try { 
			//Entry entry = fr.reg.get(myName) ; 
			   listener  = new DatagramSocket(/*entry.port()*/9876);  
			   byte[] receiveData = new byte[1024];     
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
				listener.receive(receivePacket);   
				String sentence = new String( receivePacket.getData());      
				System.out.println("RECEIVED: " + sentence.toString());  
				unmarshall(receivePacket.getData());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				listener.close();
		}
	}
}
