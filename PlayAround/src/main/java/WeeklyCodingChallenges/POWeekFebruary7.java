package WeeklyCodingChallenges;

import java.util.Arrays;

public class POWeekFebruary7 {

	public static boolean ascending(String number) {
		
		for(int grab=1; grab<number.length(); grab++) {
			
			String newNumber="";
			for(int add=Integer.valueOf(number.substring(0,grab)); newNumber.length()<number.length(); add++) {
				
				newNumber += Integer.toString(add);
				
			}
			if (newNumber.equals(number)) {
				return true;
			}
			
		}
		return false;
	}
	
	public static int[][] squarePatch(int size) {
		
		int [][] sq = new int [size][size];
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				sq[i][j]=size;
		
		return sq;
		
	}
	
	
/*		
		An attempt I made using an alternate method, until it got too complex and bug-ridden!
		For my personal use only, you can ignore this. I know if this was enterprise code, this would
		be completely removed from the codefile to be professional.



		//Pad the string to prevent running off the end when obtaining substrings.
		String dash = "-";
		String numberCheck = number+dash.repeat(number.length());
		
		String test;
		int current;
		int nextValue = -1;
		
		//loop for length of the number
		for(int numlen=1; numlen<=(number.length()/2); numlen++) {
			
			int oldValue = Integer.valueOf(number.substring(0,numlen));
			int good = 1;
			
			//loop for piece of the string
			for(int piece=numlen; piece<number.length()+1; piece += numlen) {
				
				if (piece+numlen <= number.length()) {
				nextValue = Integer.valueOf(number.substring(piece,piece+numlen));
				System.out.println("<<<"+number.substring(piece,piece+numlen));
				System.out.println("Input number:"+number+" Number length: "+numlen+" Piece:"+piece+" Piece+numlen: "+(piece+numlen)+" Current test: "+nextValue);
					
					System.out.println("Next Value: "+nextValue+" Old Value: "+oldValue);
					if (nextValue != oldValue+1) {	
						good = 0;
						//break;
					}
					
					oldValue = nextValue;
					
					//see if the number is all nines. Add 1 to the value, and see if the length increases.
					//if so, incriment numlen.
					if(Integer.toString(oldValue+1).length() > Integer.toString(oldValue).length()) {
						System.out.println("---- Length increased from "+Integer.toString(oldValue).length()+" to "+Integer.toString(oldValue+1).length()+" ----");
						numlen = numlen +1;
					}
				
				} else {
					System.out.println("Piece is: "+piece+ " Length of number is: "+number.length()+ " Good:"+good);
					if (good==1 && piece==number.length()) {
						System.out.println("\n The function is now returning true...\n");
						return true;
					}
				}
			}
			
			
		}
		
		
		System.out.println("\n The function is now returning false...\n"); */

	
	
	
	
	
	public static void main(String[] args) {
	
		System.out.println(ascending("9596979899100101102103")); //--> true
		
		System.out.println(ascending("123456789")); //--> true
		
		System.out.println(ascending("2763427635")); //--> true
		
		System.out.println(ascending("232425")); //--> true
		// Consecutive numbers 23, 24, 25

		System.out.println(ascending("2324256")); //--> false
		// No matter how this string is divided, the numbers are not consecutive.

		System.out.println(ascending("444445")); //--> true
		// Consecutive numbers 444 and 445.
		
		System.out.println(Arrays.deepToString(squarePatch(4)));
		System.out.println(Arrays.deepToString(squarePatch(0)));
		System.out.println(Arrays.deepToString(squarePatch(1)));
		System.out.println(Arrays.deepToString(squarePatch(9)));
		
		
	}
	
	
}
