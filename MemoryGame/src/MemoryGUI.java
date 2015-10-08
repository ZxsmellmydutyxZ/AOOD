import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.*;
import java.awt.event.*;


public class MemoryGUI implements ActionListener{

	JFrame frame;
	private JTable table;
	static Board board = new Board();
	int turn = 0;
	int matches = 0;
	int playercount = 0;
	int matchlimit = 0;
	public ArrayList<Player> players = new ArrayList<Player>();
	JLabel lblTurn;
	JLabel lblNewLabel;
	JLabel lblPlayer;
	JLabel lblStats;
	
	
	static ArrayList<JButton> bs = new ArrayList<JButton>();

	/**
	 * Create the application.
	 */
	public MemoryGUI() {
		initialize();
		
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 69, 637, 313);
		frame.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		
		lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(20, 44, 46, 14);
		frame.getContentPane().add(lblPlayer);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(60, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblTurn = new JLabel("turn.");
		lblTurn.setBounds(116, 44, 46, 14);
		frame.getContentPane().add(lblTurn);
		
		lblStats = new JLabel("New label");
		lblStats.setBounds(644, 69, 46, 14);
		frame.getContentPane().add(lblStats);
		
		
		
		
		
		
	}
	public static void createGrid(JPanel panel, int numRows, int numCol) 
	{
		
	    panel.setLayout(new GridLayout(numRows, numCol));
	    for (int c = 0; c < numCol; c++)
	    {
	        for (int r = 0; r < numRows; r++)
	        {
	        
	        
	       
	        String card = board.getCard(r, c).getType();
	        String aas = card;
	        
	        JButton button = new JButton();
	        button.setSize(50, 180);
	        bs.get(1).setText(card);
	        button.setText("X");
	        
	        final String ls = aas;
	        bs.get(0).addActionListener(new ActionListener(){
	        
	       
	            public void actionPerformed(java.awt.event.ActionEvent evt) 
	            {
	            	
	            bs.get(0).setText(ls);
	            
	            
	            }
	        });
	        panel.add(button);
	        
	        }
	        
	    	
	    }
	    
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
		for(int i = 1; i <= playercount;i++){
			 
			String hh = Integer.toString(i);
			Player e = players.get(i);
			e.setName(hh);
			players.set(i, e);
			
		}
		String pp = null;
		for(;matches<=matchlimit;turn=++turn % playercount){
			
			
			pp = players.get(turn).getName();
			
			
			
		}
		lblTurn.setText(pp);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
