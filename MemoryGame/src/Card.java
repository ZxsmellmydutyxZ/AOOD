import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Card {

	Object d;
	private String type;
	private boolean found = false;
	
	public Card(String t){
		type = t;
	}
	public String getType(){
		String o = "O";
		if(this.found == true){
			return o;
		}else{
			return type;

		}
		
		
	}
	public boolean check(Card card) {
		
		if(type.equals(card.getType()) && card!=this){
			this.found = true;
			card.found = true;
			
			return true;
		}else{
		return false;
		}
	}
	public boolean isFound() {
		
		return this.found;
	}

}
