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


public class MemoryGUI {

	private JFrame frame;
	private JTable table;
	static Board board = new Board();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryGUI window = new MemoryGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.setBounds(100, 100, 653, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 40, 637, 342);
		frame.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		
		
		
		
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
