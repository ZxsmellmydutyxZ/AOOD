import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Board {
	
	ArrayList<String> ani = new ArrayList<String>();
	
	//initializes the board size
	
	final int row = 3;
	final int col = 6;
	private Card[][] board;
	

	public Board(){
		
		Scanner s = null;
		try {
			s = new Scanner(new File("src/Animals.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //reads the card types from the file
		while(s.hasNext()){
			ani.add(s.nextLine());
		}
	
		for(int i = 0; i<ani.size();i++){	//randomizes card types
			Collections.shuffle(ani);
		}
		board = new Card[row][col];	

		for(int i=0;i<board.length;i++){				//creates an array of cards
			for(int j=0;j<board[0].length;j++){
				board[i][j] = new Card(ani.remove(0));
				
			}
		}
	}
	public Card getCard(int r, int c){	//gets card off the board at given position
		Card type;
		type = board[r][c];
		return type;

	}
	public void Print(){	//Prints board (unhidden)

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j].getType() + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
	public void reveal(int x, int y, int x1, int y1) {	//Reveals the card that is selected
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if((x==i && y==j) || (x1==i &&y1==j)){
					System.out.print(" "+ board[i][j].getType() + " ");
				}else{
					if(board[i][j].isFound()){
						System.out.print(" O ");
					}else{
					System.out.print(" X ");
					}
				}
			}
			System.out.println();
		}	
	}
	public void blankBoard(){	//Prints out an entirely hidden board
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(" X ");
			}
			System.out.println();
		}
	}
	public void ReplaceX(int x, int y, int x1, int y1) {	//replaces an already chosen card
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

