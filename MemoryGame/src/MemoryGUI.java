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
import java.awt.Font;
import java.awt.Color;


public class MemoryGUI implements ActionListener{
	
	
	//initialize all components on the board.
	static JFrame frmWelcomeToMemory;
	private JTable table;
	static Board board = new Board();
	static int turn = 1;
	
	static int cardsflipped = 0;
	static String matches = "1";
	static int playercounter = 0;
	static int matchlimiter = 0;
	static ArrayList<Card> pickedcards = new ArrayList<Card>();
	
	public static int pick = 0;
	public static ArrayList<Player> players = new ArrayList<Player>();
	JLabel lblTurn;
	static JLabel lblNewLabel;
	static JLabel lblStats;
	static JLabel lblNewLabel_1;
	
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
		
		
		
		//initialize JFrame component properties.
		
		frmWelcomeToMemory = new JFrame();
		frmWelcomeToMemory.setTitle("Welcome to Memory");
		frmWelcomeToMemory.getContentPane().setBackground(Color.CYAN);
		frmWelcomeToMemory.setBounds(100, 100, 650, 420);
		frmWelcomeToMemory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToMemory.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 69, 637, 313);
		frmWelcomeToMemory.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		
		
		lblNewLabel = new JLabel("Player 0's ");
		lblNewLabel.setBounds(10, 44, 66, 14);
		frmWelcomeToMemory.getContentPane().add(lblNewLabel);
		
		
		lblTurn = new JLabel("turn.");
		lblTurn.setBounds(69, 44, 46, 14);
		frmWelcomeToMemory.getContentPane().add(lblTurn);
		
		lblStats = new JLabel(" ");
		lblStats.setBounds(578, 44, 46, 14);
		frmWelcomeToMemory.getContentPane().add(lblStats);
		
		lblNewLabel_1 = new JLabel("Player 0's ");
		lblNewLabel_1.setBounds(461, 44, 63, 14);
		frmWelcomeToMemory.getContentPane().add(lblNewLabel_1);
		
		lblScore = new JLabel("score:");
		lblScore.setBounds(522, 44, 46, 14);
		frmWelcomeToMemory.getContentPane().add(lblScore);
		
		JLabel lblMemory = new JLabel("MEMORY!");
		lblMemory.setForeground(Color.BLUE);
		lblMemory.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMemory.setBounds(256, 11, 135, 26);
		frmWelcomeToMemory.getContentPane().add(lblMemory);
		
		
		
		
		
		//creates a grid of buttons/cards.
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
	        button.setBackground(Color.LIGHT_GRAY);
	        cardcard.setButton(button);
	        
	        final JButton bb = cardcard.getButton();
	        
	        
	        
	        //adds listener to the cards.
	        cardcard.getButton().addActionListener(new ActionListener(){

	      
	        
	       public void actionPerformed(ActionEvent evt) {
	        	
	    	   int x = 0;
	        	int y = 0;
	        
	        //limits the selected card limit to 2 cards.	
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
	        			
	        			//checks to see if the cards selected match
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
	        	//resets turn when it gets to end of player list.
	        	if(++turn>playercounter+1){
        			turn = 1;
        			
        			}
	        	
	        	lblNewLabel.setText(players.get(turn-1).getName() + "'s");
	        	lblNewLabel_1.setText(players.get(turn-1).getName() + "'s");
	        	matches = String.valueOf(players.get(turn-1).getMatches());
	        	lblStats.setText(matches);
	        	
	        	//clears buttons. 
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
	        	for(int i = 0; i<=playercounter; i++){
		        	
	        	//ends game when match limit is reached.
		        if(players.get(i).getMatches() == matchlimiter+1){
		        	GameOver frame = new GameOver();
		        	frame.ender(players.get(i));
		       
		        	
		        	}
		        }
	        	
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
	
//launches the game, passes in parameters recieved from GameProperties.	
public void Start(int playercount, int matchlimit){
		
		playercounter = playercount;
		matchlimiter = matchlimit;
		
		
		
		MemoryGUI window = new MemoryGUI();	
		window.frmWelcomeToMemory.setVisible(true);
			
		//gets player count.
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


	

