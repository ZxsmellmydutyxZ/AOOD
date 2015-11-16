import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MemoryListener implements ActionListener{

	private JButton bb;
	MemoryGUI gui;
	private Card card;
	
	public MemoryListener(MemoryGUI gui, JButton bb, Card card){
		this.bb = bb;
		this.gui = gui;
		this.card = card;
	}
		@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int x = bb.getX();
    	int y = bb.getY();
    	gui.action(x,y,card, e);
    	
	}

}
