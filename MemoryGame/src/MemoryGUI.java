import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
	static int playerturn = turn-1;
	static int cardsflipped = 0;
	static String matches = "1";
	static int playercounter = 0;
	int matchlimit = 0;
	static ArrayList<Card> pickedcards = new ArrayList<Card>();
	
	public static int pick = 0;
	public static ArrayList<Player> players = new ArrayList<Player>();
	JLabel lblTurn;
	static JLabel lblNewLabel;
	static JLabel lblStats;
	static JLabel lblNewLabel_1;
	//public static Card[][] cards;
	public int r = 3;
	public int c = 6;
	private JLabel lblScore;
	
	
	
	

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
		
		lblNewLabel = new JLabel("Player 0's ");
		lblNewLabel.setBounds(10, 44, 66, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblTurn = new JLabel("turn.");
		lblTurn.setBounds(86, 44, 46, 14);
		frame.getContentPane().add(lblTurn);
		
		lblStats = new JLabel(" ");
		lblStats.setBounds(644, 88, 46, 14);
		frame.getContentPane().add(lblStats);
		
		lblNewLabel_1 = new JLabel("Player 0's ");
		lblNewLabel_1.setBounds(637, 44, 63, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblScore = new JLabel("score.");
		lblScore.setBounds(699, 44, 46, 14);
		frame.getContentPane().add(lblScore);
		
		
		
		
		
		
	}
	public static void createGrid(JPanel panel, int numRows, int numCol) 
	
	{
		
	    panel.setLayout(new GridLayout(numRows, numCol));
	    for (int c = 0; c < numCol; c++)
	    {
	        for (int r = 0; r < numRows; r++)
	        {
	        	
	        
	        final Card cardcard = board.getCard(r,c);
	        String cardName = cardcard.getType();
	       
	        
	        final String aas = cardName;
	        
	        JButton button = new JButton();
	        JButton button1 = new JButton();
	        
	        
	        button.setSize(50, 180);
	        cardcard.setButton(button);
	        
	        final JButton bb = cardcard.getButton();
	        
	        
	        cardcard.getButton().addActionListener(new ActionListener(){

	      
	        
	       public void actionPerformed(ActionEvent evt) {
	        	
	    	   int x = 0;
	        	int y = 0;
	        
	        if(cardsflipped<2){
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
	    	   		
	        		Card card = cardcard;
	        		
	        		card.actionPerformed(evt);;
	        		
	        		//bb.setText(aas);
	        		
	        		cardsflipped++;
	        		System.out.println(bb.location());
	        		pickedcards.add(card);
	        		
	        		pick++;
	        		System.out.println(pickedcards.size());
	        		
	        		if(pickedcards.size()>1){
	        			
	        			if(pickedcards.get(0).check(pickedcards.get(1))){
	        				System.out.println("wow");

		        				players.get(turn-1).addMatch();
		        				matches = String.valueOf(players.get(turn-1).getMatches());
		        				
		        				lblStats.setText(matches);
	        				
		        				System.out.println(players.get(turn-1).getName() + matches);
		        				lblNewLabel_1.setText(players.get(turn-1).getName() + "'s");
	        			}
	        			
	        	        
	        			
	        			
	        			
	        			
	        		}
	        }else{
	        	
	        	if(++turn>playercounter+1){
        			turn = 1;
        			
        			}
	        	
	        	lblNewLabel.setText(players.get(turn-1).getName() + "'s");
	        	lblNewLabel_1.setText(players.get(turn-1).getName() + "'s");
	        	matches = String.valueOf(players.get(turn-1).getMatches());
	        	lblStats.setText(matches);
	        	
	        	
	        	for (int c = 0; c < 3; c++)
	    	    {
	    	        for (int r = 0; r < 6; r++)
	    	        {
	    	        	
	    	        	board.getCard(c,r).clearButtons();
	    	        	
	    	        	
	    	        	}
	    	        }
	      	        	
	        	pickedcards.clear();
	        	System.out.println(pickedcards);
	        	cardsflipped = 0;
	        	
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

			String hh = "Player " + Integer.toString(i);
			
			Player e = new Player();
			e.setName(hh);
			players.add(e);
			
		}
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
}


	

