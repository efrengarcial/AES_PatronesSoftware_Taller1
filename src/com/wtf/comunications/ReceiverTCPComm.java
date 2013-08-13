package com.wtf.comunications;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.wtf.commons.Configuration;

public class ReceiverTCPComm   extends Receiver {

	
	public ReceiverTCPComm() { 
	}
	
	public  byte[] receive() {
		ServerSocket listener = null;
		try { 
			//Entry entry = fr.reg.get(myName) ; 
			listener  = new ServerSocket(Integer.parseInt(Configuration.PORT), 1000); 
			while (true) {
				// starts the event thread			       
				return new Handler(listener.accept()).run();
				//new Handler(listener.accept(),this).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				listener.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}	

	private static class Handler     {
		private Socket socket;
		private BufferedReader in;
		private InputStream iStr; 

		/**
		 * Constructs a handler thread, squirreling away the socket.
		 * All the interesting work is done in the run method.
		 */
		public Handler(Socket socket) {
			this.socket = socket;
		}

		public  byte[] run()  {
			try {

				// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				iStr= socket.getInputStream();


				while (true) {
					boolean traeDatos = false;
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					int nRead;
					byte[] data = new byte[16384];

					while ((nRead = iStr.read(data, 0, data.length)) != -1) {
						buffer.write(data, 0, nRead);
						traeDatos = true;
					}
					if (!traeDatos){
						return null;
					}
					buffer.flush();

					return buffer.toByteArray();
					
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	}
}
