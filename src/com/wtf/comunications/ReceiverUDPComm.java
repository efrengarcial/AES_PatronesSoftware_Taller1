package com.wtf.comunications;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverUDPComm extends Receiver {
	
	private int port;
	
	public ReceiverUDPComm(int port) {
		this.port= port;
	}

	public byte[] receive() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(Integer.valueOf(port));
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            return packet.getData();
        } catch (Exception e) {
        	e.printStackTrace();
        	return null;
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
