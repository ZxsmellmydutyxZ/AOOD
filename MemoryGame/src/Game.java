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
	int r2 = 0;
	int c2 = 0;
	int r3 = 0;
	int c3 = 0;
	int r4 = 0;
	int c4 = 0;
	int r5 = 0;
	int c5 = 0;
	
	for(;matches<=9;matches++){
	if(matches!=9){

	//	board.blankBoard();
	board.Print();
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
		System.out.println(matches);
	}else{
		System.out.println("You're bad.");
	}
	}else{
		System.out.println("Game Over.");
	}
	}
	}
}	