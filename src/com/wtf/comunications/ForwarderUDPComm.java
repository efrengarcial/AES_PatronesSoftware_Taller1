package com.wtf.comunications;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.wtf.commons.Entry;
import com.wtf.commons.RegistrySingleton;

public class ForwarderUDPComm extends Forwarder {

	/***
	 * Deliver
	 */
	public void deliver(String theDest, byte[] data) {

		DatagramSocket socket = null;
		Entry entry = RegistrySingleton.getInstance().get (theDest) ;
		try {
			socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName(entry.getDestinationId());
			DatagramPacket packet = new DatagramPacket(data, data.length,address, entry.getPortNr());
			socket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}
}
