import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Card implements ActionListener{
	
	JButton butt = new JButton();
	Object d;
	private String type;
	private boolean found = false;
	
	public Card(String t){
		type = t;
	}
	
	public void setButton(JButton boot){
		butt = boot;
		

	}
	
	public String getType(){	//return the cards type
		/*String o = "O";
		if(this.found == true){
			return o;
		}else{*/
			return type;

		
			
	}
	public boolean check(Card card) {	//checks to see if the cards match
		System.out.println(card.getType() + type);
		if(type.equals(card.getType()) && card!=this){
			this.found = true;
			card.found = true;
			
			return true;
		}else{
		return false;
		}
	}
	public boolean isFound() {	//card is already found indicator
		
		return this.found;
		
	}
	
	public void flip(){
		
	}
	public void actionPerformed(JButton button, ActionEvent arg0) {
		button.setText(this.getType());
		System.out.println(this.getType());
		
	}
	public void clearButtons(){
		if(this.found){
		butt.setText("("+type+")");
		}else{
		butt.setText(" ");
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
