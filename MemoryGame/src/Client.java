import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client extends Panel implements Runnable{

	private TextField tf = new TextField();
	private TextArea ta = new TextArea();
	private Socket socket;
	// The streams we communicate to the server; these come
	// from the socket
	private DataOutputStream dout;
	private DataInputStream din;
	MemoryGUI gui;
	
	public Client( String host, int port, MemoryGUI gui) {
		this.gui = gui;
		// Set up the screen
		setLayout( new BorderLayout() );
		add( "North", tf );
		add( "Center", ta );
		// We want to receive messages when someone types a line
		// and hits return, using an anonymous class as
		// a callback
		tf.addActionListener( new ActionListener() {
		public void actionPerformed( ActionEvent e ) {
		processMessage( e.getActionCommand() );
		}
		} );
		try {
			// Initiate the connection
			Socket socket = new Socket( host, port );
			// We got a connection! Tell the world
			System.out.println( "connected to "+socket );
			// Let's grab the streams and create DataInput/Output streams
			// from them
			din = new DataInputStream( socket.getInputStream() );
			dout = new DataOutputStream( socket.getOutputStream() );
			// Start a background thread for receiving messages
			new Thread( this ).start();
			} catch( IOException ie ) { System.out.println( ie ); }
			}
	private void processMessage( String message ) {
		try {
		// Send it to the server
		dout.writeUTF( message );
		// Clear out text input field
		tf.setText( "" );
		} catch( IOException ie ) { System.out.println( ie ); }
		}
	public void run() {
		try {
		// Receive messages one-by-one, forever
		while (true) {
		// Get the next message
		String message = din.readUTF();
		// Print it to our text window
		System.out.println(message);
		if(message.startsWith("TURN")){
			
			String[] params = message.substring(4).replace("\n", "").split(",");
			
			System.out.println(params[0]);
			System.out.println("ok");
			int x = Integer.parseInt(params[1]);
			int y =  Integer.parseInt(params[2]);
			System.out.println(x +" "+ y);
			//gui.action(x,y,false);
		}
		ta.append( message+"\n" );
		}
		} catch( IOException ie ) { System.out.println( ie ); }
		}
	public void turn(int p, int x, int y){
		try {
			dout.writeUTF( "TURN"+p+","+x+","+y+"\n" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		
	}
}
