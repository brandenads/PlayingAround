package MyStuff;

import java.util.Arrays;

public class magicSquareChecker {

	private static boolean isMagicSquare(int[][] square) {
		// TODO Auto-generated method stub
		//Rows, columns, diagonals must be equal.
		int size = square.length;
		int magicSum = 0;
		boolean answer = true;
		
		int sum=0;
		int sum2=0;
		int sum3=0;
		int sum4=0;
		for ( int i=0; i<size; i++) {
			
			sum3 = sum3 + square[i][i];
			sum4 = sum4 + square[(size-1)-i][i];
			
			
			
			sum = 0; 
			sum2=0;
			for (int j=0; j<size; j++) {
				sum = sum + square[i][j]; //rows
				sum2 = sum2 + square[j][i]; //columns
			}
			if(i==0) magicSum = sum;
			//System.out.println("row is: "+i+" Sum is: "+sum);
			//System.out.println("column is: "+i+" Sum is: "+sum2);
			
			if(sum != magicSum || sum2 != magicSum) {
				//System.out.println("row is: "+i+" Sum is: "+sum);
				//System.out.println("column is: "+i+" Sum is: "+sum2);
				//System.out.println("diagonal Sum is: "+sum3);
				answer = false;
				break;
			}
		}
		
		//System.out.println("diagonal Sum is: "+sum3);
		//System.out.println("antidiagonal Sum is: "+sum4);
		if (sum3 != magicSum || sum4 != magicSum) {
			//System.out.println("diagonal Sum is: "+sum3);
			//System.out.println("antidiagonal Sum is: "+sum4);
			answer = false;
		}
	
		
		return answer;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main (String[] args ) {
	
	
	int[][] a3square = new int[][] {
		{ 2, 7, 6 },
		{ 9, 5, 1 },
		{ 4, 3, 8 }
		};
		System.out.println(Arrays.deepToString(a3square)+" is a magic square: "+isMagicSquare(a3square));
		
		
	int[][] bad3square = new int[][] {
		{ 2, 7, 6 },
		{ 9, 5, 1 },
		{ 4, 3, 7 }
		};
		System.out.println(Arrays.deepToString(bad3square)+" is a magic square: "+isMagicSquare(bad3square));
	
		
	int[][] a4square = new int[][] {
		{ 16, 3, 2, 13 },
		{ 5, 10, 11, 8 },
		{ 9, 6, 7, 12 },
		{ 4, 15, 14, 1 }
		};
		System.out.println(Arrays.deepToString(a4square)+" is a magic square: "+isMagicSquare(a4square));
		
	int[][] an8square = new int[][] {	{60,53,	44,	37,	4,	13,	20,	29},
										{3,	14,	19,	30,	59,	54,	43,	38},
										{58,55,	42,	39,	2,	15,	18,	31},
										{1,	16,	17,	32,	57,	56,	41,	40},
										{61,52,	45,	36,	5,	12,	21,	28},
										{6,	11,	22,	27,	62,	51,	46,	35},
										{63,50,	47,	34,	7,	10,	23,	26},
										{8,	9,	24,	25,	64,	49,	48,	33} 
										};
	System.out.println(Arrays.deepToString(an8square)+" is a magic square: "+isMagicSquare(an8square));		
				
	
	//here
	}


}
