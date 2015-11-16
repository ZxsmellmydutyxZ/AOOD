import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GameOver extends JFrame {

	private JPanel contentPane;
	ArrayList<Player> people = new ArrayList<Player>();
	static JLabel lblNewLabel;
	int size = people.size();
	private JLabel lblNewLabel1;
	JLabel picLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameOver() {
		setTitle("GAME OVER!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Txt_IV50", Font.ITALIC, 22));

		lblNewLabel.setBounds(10, 11, 358, 55);
		panel.add(lblNewLabel);
		
		lblNewLabel1 = new JLabel();
		lblNewLabel1.setBackground(Color.WHITE);
		lblNewLabel1.setIcon(new ImageIcon("/MemoryGame/prize.jpg"));
		
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		

		lblNewLabel1.setBounds(0, 52, 424, 200);
		panel.add(lblNewLabel1);
		
		
		
		
	}
	//displays the winner of the game.
	public void ender(Player p){
		this.setVisible(true);
		lblNewLabel.setText(p.getName() + " wins!");
		
		//lblNewLabel1.setIcon(icon);
	}
}
