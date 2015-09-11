import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Card {

	Object d;
	private String type;
	public Card(String t){
		type = t;
	}
	public String getType(){
		
		return type;

	}
	public boolean check(Card card) {
		if(type.equals(card.getType()) && card!=this){
			return true;
		}else{
		return false;
		}
	}

}
