package com.wtf.comunications;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.wtf.commons.Configuration;

public class ReceiverUDPComm extends Receiver {
	
	public ReceiverUDPComm() { 
	}

	public byte[] receive() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(Integer.valueOf(Configuration.PORT));
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
