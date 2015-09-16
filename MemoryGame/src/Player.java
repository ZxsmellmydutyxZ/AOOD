
public class Player {
	private String name;
	private int matches;
	
	
	public Player(){	//Player class makes the player more dynamic. Multiple players have many components to them
		//keeps track of their name and score

		}
	public String setName(String person){
		name = person;
		
		return person;
		
	}
	
	public void addMatch(){
		matches+=1;
	}
	
	public void stats(){
		System.out.println(name + " has " + matches + " points");
	}
	
	public String getName(){
		return name;
	}
	
	public int getMatches(){
		return matches;
	}
}