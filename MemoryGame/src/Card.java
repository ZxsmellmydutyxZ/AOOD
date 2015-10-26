import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Card implements ActionListener{

	Object d;
	private String type;
	private boolean found = false;
	
	public Card(String t){
		type = t;
	}
	public String getType(){	//return the cards type
		String o = "O";
		if(this.found == true){
			return o;
		}else{
			return type;

		}
			
	}
	public boolean check(Card card) {	//checks to see if the cards match
		
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(this.getType());
		
	}
	
}
