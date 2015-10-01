import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class GameProperties extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameProperties frame = new GameProperties();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameProperties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 335, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cb1 = new JComboBox();
		cb1.setBounds(49, 43, 46, 20);
		panel.add(cb1);
		
		JComboBox cb2 = new JComboBox();
		cb2.setBounds(233, 43, 46, 20);
		panel.add(cb2);
		
		for(int i = 1; i<=10; i++){
			Object x = (Integer) i;
			cb1.addItem(x);
		}
		for(int j = 1; j<=9; j++){
			Object x1 = (Integer) j;
			cb2.addItem(x1);
			
		}
		final int players = cb1.getSelectedIndex();
		final int matchlimit = cb2.getSelectedIndex();
		
		JButton btnNewButton = new JButton("PLAY!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemoryGUI window = new MemoryGUI();
				window.Start(players, matchlimit);
			}
		});
		
		btnNewButton.setBounds(120, 70, 89, 23);
		panel.add(btnNewButton);
		
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(49, 21, 46, 14);
		panel.add(lblPlayers);
		
		JLabel lblMatches = new JLabel("Matches");
		lblMatches.setBounds(233, 18, 46, 14);
		panel.add(lblMatches);
	}
}
