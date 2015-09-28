import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MemoryGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	
	

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
		frame.setBounds(100, 100, 653, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 225);
		frame.getContentPane().add(panel);
		createGrid(panel, 3, 6);
		
		textField = new JTextField();
		textField.setBounds(448, 11, 66, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
	}
	public static void createGrid(JPanel panel, int numRows, int numCol)
	{
	    panel.setLayout(new GridLayout(numRows, numCol));
	    for (int c = 0; c < numCol; c++)
	    {
	        for (int r = 0; r < numRows; r++)
	        {
	        Board<JButton> bs = new Board<JButton>();
	        	
	        JButton button = new JButton();
	        bs.add(button);
	        
	        button.addActionListener(new java.awt.event.ActionListener()
	        
	        {
	            public void actionPerformed(java.awt.event.ActionEvent evt)
	            {
	            	bs.get(0).setText("ok");
	            }
	        });
	        panel.add(button);
	        }
	    }
	}
}
