package CodeGame;

public class ticTac {

	static int blockPlayer (int squareOne, int squareTwo ) {
		
		
		//Make sure squares are not the same, otherwise return an error flag.
		if (squareOne == squareTwo) {
			System.out.println("ERROR: The same square was given twice. ");
			return -1;
			}
		
		//The 0-indexed row number is the integer part of dividing the square number by 3.
		int rowOne = (squareOne / 3);
		int rowTwo = (squareTwo / 3);
		
		//The 0-indexed column number is the modulo of dividing the square number by 3.
		int colOne = (squareOne % 3);
		int colTwo = (squareTwo % 3);
		
		//System.out.println("Square number: "+squareOne+" row: "+rowOne+" column: "+colOne);
		
		int rowAns = -1;
		int colAns = -1;
		
		//STEP 1: Check for row and column wins. 
		//In these cases, the missing row or column number is 3 minus the sum of the numbers
		if (rowOne == rowTwo) { 
			colAns = 3 - (colOne + colTwo); 
			rowAns = rowOne; 
			System.out.println("-Row: "+rowAns+" Column: "+colAns);
			}
		
		if (colOne == colTwo) { 
			rowAns = 3 - (rowOne + rowTwo); 
			colAns = colOne; 
			System.out.println("|Row: "+rowAns+" Column: "+colAns);
			}
		
		//STEP 2: Check for negatively-sloped diagonal. Row and col numbers are the same.
		if (rowOne == colOne && rowTwo == colTwo) { 
			rowAns = 3 - (rowOne +  rowTwo); 
			colAns = rowAns; 
			System.out.println("\\Row: "+rowAns+" Column: "+colAns);
			}
		
		//STEP 3: Check for positively-sloped diagonal. Row and col numbers sum to 2.
		if (rowOne + colOne == 2 && rowTwo + colTwo == 2) {
			rowAns = 3 - (rowOne +  rowTwo); 
			colAns = 3 - (colOne +  colTwo); 
			System.out.println("/Row: "+rowAns+" Column: "+colAns);
		}
		
		//Convert row and column back to  the square number. If none of the if statements above occur,
		//then the two squares are not lined up for forming a tic-tac-toe. A -1 is returned as an error condition.
		int squareAns = 3 * rowAns + colAns;
		if (squareAns == -4) {
			System.out.println("ERROR: Squares given not suitable for forming a tic-tac-toe.");
			squareAns = -1;
		}
		
		return squareAns;
	}
	
	
	public static void main(String[] args) {
		
		//for (int i=0; i<9; i++)
		//	blockPlayer(i,1);
		int sqOne = 6;
		int sqTwo = 2 ;
		System.out.println("Given squares "+sqOne+" and "+sqTwo+
			", the square to block a tic-tac-toe is "+blockPlayer(sqOne,sqTwo));

			
		//System.out.println(blockPlayer(i,1));
	}
}
