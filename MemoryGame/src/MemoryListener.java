import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MemoryListener implements ActionListener{

	MemoryGUI gui;
	int x, y;

	public MemoryListener(MemoryGUI gui, int x, int y){
		this.gui = gui;
		this.x = x;
		this.y = y;
	}
		@Override
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// int x = bb.getX();
  //   	int y = bb.getY();
  //   	 switch (x){
		//    case 0: x = 0;
		//    break;
		//    case 106: x = 1;
		//    break;
		//    case 212: x = 2;
		//    break;
		//    case 318: x = 3;
		//    break;
		//    case 424: x = 4;
		//    break;
		//    case 530: x = 5;
		//    }
		//    switch (y){
		//    case 0: y = 0;
		//    break;
		//    case 104: y = 1;
		//    break;
		//    case 208: y = 2;
		//    break;
		//    }
    	gui.action(x,y,true);
    	
	}

}
