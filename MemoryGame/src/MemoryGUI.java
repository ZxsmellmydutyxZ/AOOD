import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class MemoryGUI {

	JFrame frame;
	private JTable table;
	static Board board = new Board();
	int turn = 0;
	int matches = 0;
	int playercount = 0;
	int matchlimit = 0;
	public ArrayList<Player> players = new ArrayList<Player>();
	

	
	

	/**
	 * Create the application.
	 */
	public MemoryGUI() {
		initialize();
		
		
		
	}
	/**
	 * Launch the application.
	 */
	public void Start(int playercount, int matchlimit){
		int playerc = playercount;
		try {
			MemoryGUI window = new MemoryGUI();
			window.frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 69, 637, 313);
		frame.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(20, 44, 46, 14);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(60, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTurn = new JLabel("turn.");
		lblTurn.setBounds(116, 44, 46, 14);
		frame.getContentPane().add(lblTurn);
		
		
		for(int i = 1; i <= playercount;i++){
			 
			String hh = Integer.toString(i);
			players.set(i,Player e);
			players.get(i).setName(hh);
			
		}
		for(;matches<=matchlimit;turn=++turn % playercount){
			
			String pp = players.get(turn).getName();
			
			lblTurn.setText(players.get(turn).getName());
			
			
			
		}
		
		
		
	}
	public static void createGrid(JPanel panel, int numRows, int numCol)
	{
		
	    panel.setLayout(new GridLayout(numRows, numCol));
	    for (int c = 0; c < numCol; c++)
	    {
	        for (int r = 0; r < numRows; r++)
	        {
	        JButton[][] jb = null;
	        ArrayList<JButton> bs = new ArrayList<JButton>();
	        String card = board.getCard(r, c).getType();
	        final String aas = card;
	        
	        JButton button = new JButton();
	        button.setSize(50, 180);
	        bs.add(button);
	        button.setText("X");
	        
	        final ArrayList<JButton> l = bs;
	        bs.get(0).addActionListener(new java.awt.event.ActionListener()
	        
	        {
	        	
	            public void actionPerformed(java.awt.event.ActionEvent evt)
	            {
	            	
	            l.get(0).setText(aas);
	            
	            }
	        });
	        panel.add(button);
	        }
	    }
	}
}
