
public class Player {
	private String name;
	private int matches;
	
	
	public Player(){

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