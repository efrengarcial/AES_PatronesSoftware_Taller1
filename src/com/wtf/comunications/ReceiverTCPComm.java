package com.wtf.comunications;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ReceiverTCPComm extends Observable implements Runnable  {
	private ServerSocket listener ; 
	private Socket s; 
	private InputStream iStr; 
	private String myName; 
	

	
	public ReceiverTCPComm(String theName) { myName = theName;}
	
	public static Object deserialize(byte[] data) {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is;
		try {
			is = new ObjectInputStream(in);
			return is.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
		return null;
	}

	@Override
	public void run() {
		int val; 
		byte buffer [] = null; 
		try { 
			//Entry entry = fr.reg.get(myName) ; 
			listener  = new ServerSocket(/*entry.port()*/528, 1000); 
			try {
				while (true) {
					 // starts the event thread
			       // Thread thread = new Thread(new Handler(listener.accept(),this));
			        //thread.start();	
					new Handler(listener.accept(),this).run();
					//new Handler(listener.accept(),this).start();
				}
			} finally {
				listener.close();
			}

			/*s = listener .accept();
			iStr = s.getInputStream(); 
			val = iStr.read () ; 
			buffer = new byte [val] ; 
			iStr.read(buffer) ; 
			iStr.close(); 
			s.close(); 
			listener.close();*/ 
		}
		catch(IOException e) {  /*  . . . */ } 
		//return buffer; 
	}

	  /**
     * A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for a dealing with a single client
     * and broadcasting its messages.
     */
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

        /**
         * Services this thread's client by repeatedly requesting a
         * screen name until a unique one has been submitted, then
         * acknowledges the name and registers the output stream for
         * the client in a global set, then repeatedly gets inputs and
         * broadcasts them.
         * @throws ClassNotFoundException 
         */
       // @Override
        public void run()  {
            try {

                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                iStr= socket.getInputStream();
                

                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                while (true) {
                    /*name = in.readLine();
                    if (name == null) {
                        return;
                    }*/
                	int val = iStr.read () ; 
                	byte [] buffer = new byte [val] ; 
                	iStr.read( buffer); 
                	Object o = this.receiver.deserialize(buffer);
                	if (o!=null) {
                		receiver.setChanged();
                		receiver.notifyObservers(buffer);
                	}
                }

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
//                if (name != null) {
//                    names.remove(name);
//                }
                if (in != null) {
                    try {
						in.close();
					} catch (IOException e) {
					}
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
