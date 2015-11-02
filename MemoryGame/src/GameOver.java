import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GameOver extends JFrame {

	private JPanel contentPane;
	ArrayList<Player> people = new ArrayList<Player>();
	static JLabel lblNewLabel;
	int size = people.size();
	private JLabel lblNewLabel_1;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vineta BT", Font.ITALIC, 25));

		lblNewLabel.setBounds(31, 31, 358, 55);
		panel.add(lblNewLabel);
		
		
		
		
	}
	//displays the winner of the game.
	public void ender(Player p){
		this.setVisible(true);
		lblNewLabel.setText(p.getName() + " wins!");
		
	}
}
