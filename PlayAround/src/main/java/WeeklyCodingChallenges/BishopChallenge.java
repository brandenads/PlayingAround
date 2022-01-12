package WeeklyCodingChallenges;

public class BishopChallenge {
	
	static int noteToNumber (String chessboardNotation) {
		//Convert chessboard notation to number representation
		//a=1, b=2, ..., h=8
		
		int letter = ((int) chessboardNotation.charAt(0)) - 96;
		int number = Character.getNumericValue(chessboardNotation.charAt(1));
		
		return letter*10 + number;
	}
	
	static int getColumn (String chessboardNotation) {
		//get the column number from the letter a-h
		return ((int) chessboardNotation.charAt(0)) - 96;
	}
	
	static int getRow(String chessboardNotation) {
		//get the row number from the chess board notation
		return Character.getNumericValue(chessboardNotation.charAt(1));
	}

	static boolean bishop (String start, String finish, int moves ) {
		
		System.out.println();
		System.out.println("The two squares provided are "+start+" and "+finish+", and "+moves+" moves are allowed.");
		
		//Moves cannot be negative
		if (moves < 0) { 
			System.out.println("ERROR: You cannot have negative moves!");
			return false;
		}
		
		//If the finish square is not the same color as the start square, the
		//bishop cannot even reach the finish square. This can be deduced by a 
		//parity check. If the sum of the row and column numbers of each square
		//are both odd or both even, they are the same color
		int startRC = getRow(start) + getColumn(start);
		int finishRC = getRow(finish) + getColumn(finish);
		int startParity = startRC % 2;
		int finishParity = finishRC % 2;
		
		if (startParity != finishParity) {
			System.out.println("The biship cannot make the move. The start and finish squares are different colors.");
			return false;
		}
		

		//There are three cases to test, given the start and finish squares are the same color.
		// 1.) They are the same square (can be done in 0 or more moves)
		// 2.) They are in a line (can be done in 1 or more moves)
		// 3.) They are not in a line (can be done in 2 or more moves)
		
		//CASE 1: They are in a the same point
		if (start.equals(finish)) {
			System.out.println("The start and finish point are the same. The bishop can just stay put!");
			return true;
		}
		
		//CASE 2: They are in a line. This can be determined by finding the slope of the line between the
		//two points. If the slope is either 1 or -1, then they are on the same line on a chessboard.
		double slope = ((double) getRow(start) - (double) getRow(finish))  / ((double) getColumn(start) - (double) getColumn(finish));
		//System.out.println(slope);
		
		//Since both -1 and 1 represent straight lines, take the absolute value just to make the variable positive 
		//and the if statement simpler.
		slope = Math.abs(slope);
		
		//At least one move is required in this case. So check if moves > 0.
		if (slope == 1.0 && moves > 0) {
			System.out.println("The start and finish points are in a straight diagonal line. The bishop can get there in one move.");
			return true;
		}
		
		//CASE 3: They are not in a line. Any 2 points of the same color can be reached with 2 moves. This can be
		//demonstrated by drawing a diagonal "X" across the chessboard from the start square in one color marker,
		//drawing another diagonal "X" from the destination square in another color marker, and seeing the one
		//(or possibly two) square(s) where different colors of marker intersect within the boundaries of the board. 
		//The diagonal "X"'s are basically all the possible squares that a bishop standing in that spot can reach.
		//So, if two or more moves are allowed, and both squares are the same color (already checked for), then the bishop can
		//reach it. 
		if (moves >= 2) {
			System.out.println ("The bishop can move between the squares in two moves.");
			return true;
		}
		
		//Now, for the catch-all case. All true cases have been accounted for so far, and patently false cases removed
		//at this point. Therefore, the only cases that fall through to here meet these three conditions.
		//1.) They are the same color.
		//2.) They are not the same point.
		//3.) They are in a line, but only 0 moves provided.
		//4.) They are not in a line, but less than 2 moves provided.
		//Therefore, the bishop cannot make the move due to an insufficient number of moves allowed.
		System.out.println("The bishop cannot make the move due to an insufficient number of moves allowed.");
		return false;
	}
	
	public static void main(String[] args) {
		
		//Cases provided on Slack
		System.out.println("<<<<<<<<<<<<<<<<<<<< Test cases on Slack >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		bishop("a1","b4",2); //true
		bishop("a1","b5",5); //false
		bishop("f1","f1",0); //true
		
		//Cases where squares are not the same color
		System.out.println("\n<<<<<<<<<<<<<<<<<<<< Squares not the same color >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		bishop("a1","c6",5); //false
		bishop("b7","d2",0); //false
		bishop("a5","h3",1); //false
		bishop("a1","b1",2); //false
		bishop("a1","a2",3); //false
		
		//Cases where squares are in a straight line
		System.out.println("\n<<<<<<<<<<<<<<<<<<<< Squares in a straht line >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		bishop("b4","e7",0); //false
		bishop("b5","f1",0); //false
		bishop("b4","e7",1); //true
		bishop("d4","e5",1); //true
		bishop("a1","h8",6); //true
		
		//Cases where squares are not in straight line, but same color
		System.out.println("\n<<<<<<<<<<<<<<<<<<<< Squares not in straight line, same color >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		bishop("a1","c7",0); //false
		bishop("a4","h3",1); //false
		bishop("f8","b2",2); //true
		bishop("a4","h3",3); //true
		bishop("a3","c7",4); //true
		
	}
}
