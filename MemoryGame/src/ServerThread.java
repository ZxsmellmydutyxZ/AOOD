import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;


public class ServerThread extends Thread{
	
	Server server;
	Socket socket;
	
	public ServerThread( Server server, Socket socket ) {
		
		this.server = server;
		this.socket = socket;
		
		start();
		}
	public void run() {
		try {
		// Create a DataInputStream for communication; the client
		// is using a DataOutputStream to write to us
		DataInputStream din = new DataInputStream( socket.getInputStream() );
		// Over and over, forever ...
		while (true) {
		// ... read the next message ...
		String message = din.readUTF();
		// ... tell the world ...
		System.out.println( "Sending "+message );
		// ... and have the server send it to all clients
		server.sendToAll( message );
		}
		} catch( EOFException ie ) {
		// This doesn't need an error message
		} catch( IOException ie ) {
		// This does; tell the world!
		ie.printStackTrace();
		} finally {
		// The connection is closed for one reason or another,
		// so have the server dealing with it
		server.removeConnection( socket );
		}
		}
}
