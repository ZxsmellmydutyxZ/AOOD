import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Board {
	String [] animals = {"Cow", "Pig", "Horse", "Chicken", "Sheep", "Cow", "Pig", "Horse", "Chicken", "Sheep", "Cat", "Dog", "Snake", "Duck", "Cat", "Dog", "Snake", "Duck"};
	ArrayList<String> ani = new ArrayList<String>(Arrays.asList(animals));
	final int row = 3;
	final int col = 6;
	private Card[][] board;

	public Board(){
		for(int i = 0; i<ani.size();i++){
			Collections.shuffle(ani);
		}
		board = new Card[row][col];

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				board[i][j] = new Card(ani.remove(0));
				//board[i][j].equals(card.getCard());
			}
		}
	}
	public Card getCard(int r, int c){
		Card type;
		type = board[r][c];
		return type;

	}
	public void Print(){

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j].getType() + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
	public void reveal(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if((x==i && y==j) || (x1==i &&y1==j) || (x2==i && y2==j) || (x3==i &&y3==j) || (x4==i && y4==j)){
					System.out.print(" "+ board[i][j].getType() + " ");
				}else{
					System.out.print(" X ");
				}
			}
			System.out.println();
		}	
	}
	public void blankBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(" X ");
			}
			System.out.println();
		}
	}
	public void ReplaceX(int x, int y, int x1, int y1) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if((x==i && y==j) || (x1==i &&y1==j)){
					System.out.print(" "+ "O" + " ");
				}else{
					System.out.print(" X ");
				}
			}
			System.out.println();
		}	
	}
	
	

}

