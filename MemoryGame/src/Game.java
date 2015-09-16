import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	

public static void main(String [] args) throws FileNotFoundException{
	Board board = new Board();
	Scanner scan = new Scanner(System.in);
	
	int matches = 0;
	int row;
	int column;
	int r = 0;
	int c = 0;
	int r1 = 0;
	int c1 = 0;
	int turn = 0;
	
	int matchlimit = 0;
	int playercount = 0;
	
	ArrayList<Player> players= new ArrayList<Player>();
	
	System.out.println("How many players are playing? ");
	playercount = scan.nextInt();
	System.out.println();
	System.out.println("How many matches will you be playing to? ");
	matchlimit = scan.nextInt();
	scan.nextLine();
	
	for(int i=0;i<playercount;i++){
		System.out.println("What is player " + (i+1) + "'s name?");
		Player p = new Player();
		p.setName(scan.nextLine());
		players.add(p);
		System.out.println();
	}

	for(;matches<matchlimit;turn=++turn % playercount){

	
		board.Print();
		board.reveal(-1, -1, -1, -1);
	
		System.out.println();
		System.out.println(players.get(turn).getName() + "'s turn.");
		
		System.out.println("Enter the position of the card you're selecting(row, column): ");
		r = scan.nextInt();
		c= scan.nextInt();
		board.reveal(r,c,-1,-1);
		System.out.println("Enter the position of the card you're selecting(row, column): ");
		r1 = scan.nextInt();
		c1 = scan.nextInt();
		board.reveal(r1,c1,r,c);	
		if(board.getCard(r, c).check(board.getCard(r1, c1))){
			System.out.println();
			System.out.println("Nice Job.");
			System.out.println();
			board.ReplaceX(r, c, r1, c1);
			System.out.println();
			matches+=1;
			players.get(turn).addMatch();
			System.out.println();
			players.get(turn).stats();
			System.out.println();
			
		}else{
			System.out.println();
			System.out.println("You're bad.");
			System.out.println();
			
		}
	
		
		
	
	}
	System.out.println("Game Over.");
	for(int i = 0;i<playercount;i++){
	Player p = players.get(i);	
	System.out.println(p.getName() + " got " + p.getMatches() + " points.");
	
	
	
		}
	}

}	