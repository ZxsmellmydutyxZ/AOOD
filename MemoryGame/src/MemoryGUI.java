import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class MemoryGUI {

	private JFrame frame;
	private JTable table;
	
	

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 225);
		frame.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		Board board = new Board();
		
		
	}
	public static void createGrid(JPanel panel, int numRows, int numCol)
	{
	    panel.setLayout(new GridLayout(numRows, numCol));
	    for (int c = 0; c < numCol; c++)
	    {
	        for (int r = 0; r < numRows; r++)
	        {
	        JButton button = new JButton();
	        button.addActionListener(new java.awt.event.ActionListener()
	        {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt)
	            {
	            
	            }
	        });
	        panel.add(button);
	        }
	    }
	}
}
