import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	ServerSocket ss;
	private Hashtable outputStreams = new Hashtable();

	
	public Server(int port) throws IOException{
		listen(port);
		ServerSocket ss = new ServerSocket( port );
		
		
		while (true) {
		
		Socket newSocket = ss.accept();
		
		}
		
	}
	
	
	
	
static public void main(String args[]) throws Exception{
	
	int port = Integer.parseInt(args[0]);
	
	new Server(port);
	
	
}
private void listen( int port ) throws IOException {
	// Create the ServerSocket
	ss = new ServerSocket( port );
	// Tell the world we're ready to go
	System.out.println( "Listening on "+ss );
	// Keep accepting connections forever
	while (true) {
	// Grab the next incoming connection
	Socket s = ss.accept();
	// Tell the world we've got it
	System.out.println( "Connection from "+s );
	// Create a DataOutputStream for writing data to the
	// other side
	DataOutputStream dout = new DataOutputStream( s.getOutputStream() );
	// Save this stream so we don't need to make it again
	outputStreams.put( s, dout );
	// Create a new thread for this connection, and then forget
	// about it
	new ServerThread( this, s );
	}

	
	
}


Enumeration getOutputStreams() {
return (outputStreams).elements();
}

// Send a message to all clients (utility routine)

public void sendToAll(String message) {
	// TODO Auto-generated method stub
	synchronized( outputStreams ) {
		// For each client ...
		for (Enumeration e = getOutputStreams(); e.hasMoreElements(); ) {
		
		// ... get the output stream ...
		DataOutputStream dout = (DataOutputStream)e.nextElement();
		// ... and send the message
		try {
		dout.writeUTF( message );
		} catch( IOException ie ) { System.out.println( ie ); }
		}
	}
}



public void removeConnection(Socket s){
	// TODO Auto-generated method stub
	synchronized( outputStreams ) {
		// Tell the world
		System.out.println( "Removing connection to "+s );
		// Remove it from our hashtable/list
		outputStreams.remove( s );
		// Make sure it's closed
		try {
		s.close();
		} catch( IOException ie ) {
		System.out.println( "Error closing "+s );
		ie.printStackTrace();
		}
		}
             
}

}
