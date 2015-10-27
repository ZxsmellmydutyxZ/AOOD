import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class MemoryGUI implements ActionListener{

	JFrame frame;
	private JTable table;
	static Board board = new Board();
	static int turn = 1;
	static int cardsflipped = 0;
	int matches = 0;
	static int playercounter = 0;
	int matchlimit = 0;
	public ArrayList<Player> players = new ArrayList<Player>();
	JLabel lblTurn;
	JLabel lblNewLabel;
	JLabel lblPlayer;
	JLabel lblStats;
	public static Card[][] cards;
	public int r = 3;
	public int c = 6;
	

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
	        final String aas = card;
	        
	        JButton button = new JButton();
	        JButton button1 = new JButton();
	        
	        button.setSize(50, 180);
	        
	        
	        final JButton bb = button;
	        
	        
	        bb.addActionListener(new ActionListener(){
	        
	      
	        
	       public void actionPerformed(ActionEvent evt) {
	        	int x = 0;
	        	int y = 0;
	        if(cardsflipped<18){
	        	
	    	   switch (bb.getX()){
	    	   case 0: x = 0;
	    	   break;
	    	   case 106: x = 1;
	    	   break;
	    	   case 212: x = 2;
	    	   break;
	    	   case 318: x = 3;
	    	   break;
	    	   case 424: x = 4;
	    	   break;
	    	   case 530: x = 5;
	    	   }
	    	   switch (bb.getY()){
	    	   case 0: y = 0;
	    	   break;
	    	   case 104: y = 1;
	    	   break;
	    	   case 208: y = 2;
	    	   break;
	    	   }
	        		
	        		board.getCard(y,x).actionPerformed(bb,evt);;
	        		//bb.setText(aas);
	        		
	        		cardsflipped++;
	        		System.out.println(bb.location());
	        }
	       }
	        });
	        
	        panel.add(bb);
	        
	        }
	    
	
	          	
	    }
	    
}
	
	/**
	 * Launch the application.
	 */
	
	public void Start(int playercount, int matchlimit){
		
		playercounter = playercount;
		
		MemoryGUI window = new MemoryGUI();	
		window.frame.setVisible(true);
				
		for(int i = 0; i <= playercounter;i++){
			 
			String hh = Integer.toString(i);
			Player e = new Player();
			e.setName(hh);
			players.add(e);
			System.out.println(players.get(i).getName() );
		}
		
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
}


	

