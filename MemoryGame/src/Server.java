import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class Server {
	
	ServerSocket ss;
	HashMap outputStreams = new HashMap();
	
	public Server(int port) throws IOException{
		listen(port);
		ServerSocket ss = new ServerSocket( port );
		
		
		while (true) {
		
		Socket newSocket = ss.accept();
		
		}
		
	}
	
	
	
	
public static void main(String args[]) throws Exception{
	
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
	
}
