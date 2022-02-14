package MyStuff;

import java.util.Arrays;

public class playTicTacToe {

	private static String ticTacToe(boolean first, int[] plays) {
		
		
		//The method takes in a boolean, and an integer array.
		//The boolean 'first' will be true if X goes first, and false if O goes first.
		//
		//The grid squares are labeled as follows:
		//
		//       7    8    9
		//
		//       4    5    6
		//
		//       1    2    3
		//
		//The method needs to:
		//1.) Print out the move "X has marked square 9"
		//2.) Print out the resulting grid. for each move.
		//3.) Print one of four results:
		//		a.) If X or O wins, it should print "X (or O) has won", and STOP at this point.
		//		b.) If there is a tie, it should say so.
		//      c.) If the game is incomplete, it should print that it is incomplete.
		
		//Place the "X" and "O" in this array for printing.
		String [] boardToPrint = {"-","-","-","-","-","-","-","-","-","-"};
		
		//let 0 = blank, 1 = X, -1 = O. The array index is the same number as the square.
		int [] boardToCompute = new int[10];
		boolean X = true;
		boolean O = false;
		
		
		boolean turn = first;
		
		for (int i=0; i<plays.length; i++) {
			
			if (turn == X) {
				System.out.println("X has marked square "+plays[i]);
				boardToPrint[plays[i]] = "X";
				boardToCompute[plays[i]] = 1;
			}
			if (turn == O) {
				System.out.println("O has marked square "+plays[i]);
				boardToPrint[plays[i]] = "O";
				boardToCompute[plays[i]] = -1;
			}
			
			printTheBoard(boardToPrint);	
			
			//Top line
			//horizontal rows.
			for (int j=1; j<8; j+= 3) {
				int sum= boardToCompute[j]+boardToCompute[j+1]+boardToCompute[j+2];
				if ( sum == 3) {
					return "X has won!";
				}
				if ( sum == -3) {
					return "O has won!";
				}
			}
			
			
			
			turn = !turn;
		}
		
		
		
		return "Not implemented yet";
	}
	
	public static void printTheBoard(String [] board) {
		
		System.out.println();
		System.out.println("The current board is:");
		System.out.println(board[7]+" "+board[8]+" "+board[9]);
		System.out.println(board[4]+" "+board[5]+" "+board[6]);
		System.out.println(board[1]+" "+board[2]+" "+board[3]);
		System.out.println();
		
	}
	
	
	
	public static void main(String[] args) {
		
		boolean X = true;
		boolean O = false;
		
		//int[] play1 = {7,4,8,5,9}; // x win first row.
		int[] play2 = {1,4,2,5,3}; // x win first row.
		//int[] play1 = {7,4,8,5,9,6}; //x
		//int[] play2 = {7,4,5,2,3}; //o
		//int[] play3 = {7,8,9,4,6,5,1,3,2}; //none
		//int[] play4 = {7,5,3,1}; //incomplete
		
		//System.out.println(ticTacToe(X,play1));
		System.out.println(ticTacToe(X,play2));
		//System.out.println(ticTacToe(O,play3));
		//System.out.println(ticTacToe(X,play4));
		
		
	}


	
	
	
	
	
}
