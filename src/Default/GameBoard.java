package Default;

public class GameBoard {

	//First dimension indicates row, second dimension indicates column
	private char[][] board = new char[3][3]; 
	
	public GameBoard() {
		setup();
	}
	
	/**
	 * Sets up the game board.
	 */
	private void setup() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public void newGame() {
		setup();
	}
	
	/**
	 * Places a mark in the player's chosen square.
	 * @param square An array of two ints; first int indicates row, second int indicates column 
	 * @param mark The current player's mark
	 * @return True if there's already a mark in that spot, false otherwise
	 */
	public boolean setMark(int row, int column, char mark) {
		boolean hasMark = false;
		if(board[row][column] == ' ') {
			board[row][column] = mark;
		} else {
			System.out.println("Someone has already claimed this square. Pick a different square.");
			hasMark = true;
		}
		return hasMark;
	}
	
	/**
	 * Returns the mark in the specified square.
	 * @param square The grid location being asked about
	 * @return The mark in this spot as a char
	 */
	public char getMark(int row, int column) {
		return board[row][column];
	}
	
	public boolean isGameOver(char mark) {
		boolean hasMark;
		
		//check all the rows
		int row = 0;
		int column = 0;
		while(row < 3) {
			hasMark = false;
			column = 0;
			while((column < 3) && ((column == 0) || hasMark)) {
				if(board[row][column] == mark) {
					hasMark = true;
				} else {
					hasMark = false;
				}
				column++;
			}
			if(hasMark) {
				return true;
			}
			row++;
		}
		
		//check all the columns
		row = 0;
		column = 0;
		while(column < 3) {
			hasMark = false;
			row = 0;
			while((row < 3) && ((row == 0) || hasMark)) {
				if(board[row][column] == mark) {
					hasMark = true;
				} else {
					hasMark = false;
				}
				row++;
			}
			if(hasMark) {
				return true;
			}
			column++;
		}
		
		//check the diagonal from top-left to bottom-right
		hasMark = false;
		row = 0;
		while((row < 3) && ((row == 0) || hasMark)) {
			if(board[row][row] == mark) {
				hasMark = true;
			} else {
				hasMark = false;
			}
			row++;
		}
		if(hasMark) {
			return true;
		}
		
		//check the diagonal from top-right to bottom-left
		hasMark = false;
		if(board[0][2] == mark) {
			hasMark = true;
		} else {
			hasMark = false;
		}
		if(hasMark) { //if previous square has the mark, check next square
			 if(board[1][1] == mark) {
				 hasMark = true;
			 } else {
				 hasMark = false;
			 }
			 if(hasMark) { //if previous square has the mark, check next square
				 if(board[2][0] == mark) {
					 return true;
				 }
			}
		}

		return false;
	}
	
	/**
	 * Prints one line of chars.
	 * @param marks Array of chars on the indicated line
	 */
	private void printLine(char[] marks) {
		for(int i = 0; i < 3; i++) {
			System.out.print(" " + marks[i] + " ");
			if(i < 2) {
				System.out.print("|");
			} else {
				System.out.print("\n");
			}
		}
	}
	
	/**
	 * Prints the board to the console.
	 */
	public void printBoard() {
		System.out.println();
		System.out.println("   1   2   3");
		for(int i = 0; i < 3; i++) {
			System.out.print((i + 1) + " ");
			printLine(board[i]);
			if(i < 2) {
				System.out.println("  -----------");
			} else {
				System.out.println();
			}
		}
	}
	
}
