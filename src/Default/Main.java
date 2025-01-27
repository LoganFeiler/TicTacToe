package Default;
import java.util.Scanner;

public class Main {
	
	private static final GameBoard BOARD = new GameBoard();
	private static int currPlayer = 0;
	private static final char player0 = 'X';
	private static final char player1 = 'O';
	
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			boolean pickNewSquare = false;
			boolean gameOver = false;
			boolean endGame = false;
			int row;
			int column;
			char mark;
			while(!endGame) {
				BOARD.printBoard();
				while(!gameOver) {
					if(currPlayer == 0) {
						mark = player0;
					} else {
						mark = player1;
					}
					System.out.println("Current Player: " + (currPlayer + 1) + " (" + mark + ")");
					System.out.println("What row do you want to place your mark in?");
					row = scan.nextInt() - 1;
					System.out.println("What column do you want to place your mark in?");
					column = scan.nextInt() - 1;
					pickNewSquare = BOARD.setMark(row, column, mark);
					BOARD.printBoard();
					if(BOARD.isGameOver(mark)) {
						System.out.println("Player " + (currPlayer + 1) + " won the game!");
						gameOver = true;
					}
					if(!pickNewSquare) {
						currPlayer = (currPlayer + 1) % 2;
					}
				}
				System.out.println("Would you like to play another game?");
				String answer = scan.next();
				answer = answer.toLowerCase();
				if((answer.compareTo("no") == 0) || (answer.compareTo("n") == 0)) {
					System.out.println("Thank you for playing!");
					endGame = true; //end the game
				} else { //start a new game
					gameOver = false;
					BOARD.newGame();
					currPlayer = 0;
					System.out.println();
				}
			}
		}
	}
}
