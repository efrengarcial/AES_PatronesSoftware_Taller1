package com.wtf.comunications;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import com.wtf.comunications.messages.Message;

public class ForwarderUDPComm {

	private String host;
	private int port;
	
	private Socket s; 
	private OutputStream oStr; 
	
	
	/***
	 * Parameterized constructor
	 * @param host
	 * @param port
	 */
	public ForwarderUDPComm(String host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	
   public void deliver(Message msg){
			
			DatagramSocket socket = null;
			try {
				byte[] messageBytes=serialize(msg);
				socket = new DatagramSocket();
				InetAddress address = InetAddress.getByName(host);
				DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, address, port);
				socket.send(packet);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					socket.close();
				}
			}
		}
	
	public  byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
	
}
