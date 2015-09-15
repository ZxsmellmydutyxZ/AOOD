import java.util.ArrayList;
import java.util.Scanner;


public class Game {
	

public static void main(String [] args){
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
	Player one = new Player();
	Player two = new Player();
	Player three = new Player();
	Player four = new Player();
	int matchlimit = 0;
	int playercount = 0;
	
	ArrayList<Player> players= new ArrayList<Player>();
	
	
	
	
	System.out.println("How many players are playing? ");
	playercount = scan.nextInt();
	System.out.println();
	System.out.println("How many matches will you be playing to? ");
	matchlimit = scan.nextInt();
	scan.nextLine();
	
	if(playercount == 1){
		System.out.println("What is player 1's name?");
		one.setName(scan.nextLine());
		players.add(one);
		System.out.println();
	}if(playercount == 2){
		System.out.println("What is player 1's name?");
		one.setName(scan.nextLine());
		players.add(one);
		System.out.println("What is player 2's name?");
		two.setName(scan.nextLine());
		System.out.println();
		players.add(two);
	}if(playercount == 3){
		System.out.println("What is player 1's name?");
		one.setName(scan.nextLine());
		players.add(one);
		System.out.println("What is player 2's name?");
		two.setName(scan.nextLine());
		players.add(two);
		System.out.println("What is player 3's name?");
		three.setName(scan.nextLine());
		players.add(three);
		System.out.println();
	}if(playercount == 4){
		System.out.println("What is player 1's name?");
		one.setName(scan.nextLine());
		players.add(one);
		System.out.println("What is player 2's name?");
		two.setName(scan.nextLine());
		players.add(two);
		System.out.println("What is player 3's name?");
		three.setName(scan.nextLine());
		players.add(three);
		System.out.println("What is player 4's name?");
		four.setName(scan.nextLine());
		players.add(four);
		System.out.println();
	}
	
	for(;matches<matchlimit;turn=++turn % playercount){

	
		board.Print();
		board.reveal(-1, -1, -1, -1);
	
		
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
	
	System.out.println(one.getName() + " got " + one.getMatches() + " points.");
	System.out.println(two.getName() + " got " + two.getMatches() + " points.");
	System.out.println(three.getName() + " got " + three.getMatches() + " points.");
	}

}	