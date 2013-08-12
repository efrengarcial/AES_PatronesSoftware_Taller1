package com.wtf.comunications;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ReceiverTCPComm extends Observable  implements IReceiverComm {
	private ServerSocket listener ; 
	private String myName; 

	public ReceiverTCPComm(String theName) { 
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
		acceptConnection();
	}

	private void acceptConnection() {
		try { 
			//Entry entry = fr.reg.get(myName) ; 
			listener  = new ServerSocket(/*entry.port()*/528, 1000); 
			while (true) {
				// starts the event thread			       
				new Handler(listener.accept(),this).run();
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
	}


	private static class Handler     {
		private String name;
		private Socket socket;
		private BufferedReader in;
		private InputStream iStr; 
		private ReceiverTCPComm receiver;

		/**
		 * Constructs a handler thread, squirreling away the socket.
		 * All the interesting work is done in the run method.
		 */
		public Handler(Socket socket,ReceiverTCPComm receiver) {
			this.socket = socket;
			this.receiver = receiver;
		}

		public void run()  {
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
						return ;
					}
					buffer.flush();

					Object mensaje = this.receiver.unmarshall(buffer.toByteArray());
					if (mensaje!=null) {
						receiver.setChanged();
						receiver.notifyObservers(mensaje);
					}
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
		}
	}
}
