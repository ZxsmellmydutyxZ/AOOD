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
	Player[] players = new Player[2];
	players[0] = new Player();
	players[1] = new Player();
	
	System.out.println("What is player 1's name?");
	players[0].setName(scan.nextLine());
	System.out.println("What is player 2's name?");
	players[1].setName(scan.nextLine());
	
	
	for(;matches<=2;turn=++turn % 2){

	
		//board.Print();
		board.reveal(-1, -1, -1, -1);
	
		
		System.out.println(players[turn].getName() + "'s turn.");
		
		System.out.println("Enter the position of the card you're selecting(row, column): ");
		r = scan.nextInt();
		c= scan.nextInt();
		board.reveal(r,c,-1,-1);
		System.out.println("Enter the position of the card you're selecting(row, column): ");
		r1 = scan.nextInt();
		c1 = scan.nextInt();
		board.reveal(r1,c1,r,c);	
		if(board.getCard(r, c).check(board.getCard(r1, c1))){
			System.out.println("Nice Job.");	
			board.ReplaceX(r, c, r1, c1);
			System.out.println();
			matches+=1;
			players[turn].addMatch();
			players[turn].stats();
			System.out.println();
			
		}else{
			System.out.println("You're bad.");
			System.out.println();
			
		}
	
		
		
	
	}
	System.out.println("Game Over.");
	
	System.out.println(players[0].getName() + " got " + players[0].getMatches() + " points.");
	System.out.println(players[1].getName() + " got " + players[1].getMatches() + " points.");
	
	}

}	