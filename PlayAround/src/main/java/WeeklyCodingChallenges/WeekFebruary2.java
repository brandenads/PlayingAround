package WeeklyCodingChallenges;

import java.util.Arrays;

public class WeekFebruary2 {

	public static boolean isHeteromecic(int number) {
		
		for (int i=0; i<=Math.sqrt(number)+1; i++) {
			if (i*(i+1) == number) {
				//System.out.println(i+" x "+(i+1)+" = "+number);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean happy(int number) {
		
		//System.out.println("The number is "+number);
		
		//int old = number+1;
		int nnew = number;
		while (number >= nnew && number > 1) {
			
			number = nnew;
			
			//Square the digits and add them
			nnew = 0;
			for(int i=1; i<=getDigit(number,0); i++) {
				nnew += getDigit(number, i)*getDigit(number, i);
			}
			//System.out.println("The next number is "+nnew);
		
		}
		
		if (number == 1) return true;
		return false;
	}
	
	public static boolean is_disarium(int number) {
		
		int total = 0;
		for (int i=1; i<=getDigit(number,0); i++) {
			total += Math.pow(getDigit(number, -i), i);
			//System.out.println(getDigit(number, -i)+"^"+i+"="+Math.pow(getDigit(number, -i), i));
		}
		
		//System.out.println(total);
		if (total == number) return true;
		return false;
	}
	
	
	public static int getDigit(int number, int n) {
		
		//Gets the nth digit of a number, from the RIGHT. 
		//If n is beyond the digits of the number, returns -1.
		//If n is 0, returns the magnitude of the number
		//If n is < 0, returns the nth digit from the LEFT.
		
		//find order of magnitude of the number
		String nString = Integer.toString(number);
		int magnitude = nString.length();
		
		if(n > magnitude) return -1;
		
		if(n == 0) return magnitude;
		
		if (n < 0) {
			n = n * -1;
			if (n > magnitude) return -1;
			return Character.getNumericValue(nString.charAt(n - 1));
		}
		
		return Character.getNumericValue(nString.charAt(magnitude - n));
		
	}
	
	public static String atbash(String plaintext) {
		
		StringBuilder ciphertext = new StringBuilder();
		
		for (int i=0; i<plaintext.length(); i++) {
			
			int letter = plaintext.charAt(i);
			
			int subtractor = letter * 2;
			if (letter >= 'A' && letter <= 'Z') subtractor = 155;
			if (letter >= 'a' && letter <= 'z') subtractor = 219;
			
			ciphertext.append(Character.toChars(subtractor - letter));
			
		}
		
		return ciphertext.toString();
	}
	
	public static boolean isMagicSquare (int[][] square) {
		
		int rowSum=0; //row sum (-)
		int colSum=0; //column sum (|)
		int posSum=0; //positive sloped diagonal (/)
		int negSum=0; //negatively sloped diagonal (\)
		int magicNum = 0; //the target sum
		int size = square.length; //the size of the magic square
				
		for (int outer=0; outer<size; outer++) {
			
			negSum += square[outer][outer]; //negatively sloped diagonal
			posSum += square[outer][(size-1)-outer]; //positively sloped diagonal
			
			rowSum=0;
			colSum=0;
			for(int inner=0; inner<size; inner++) {
				
				rowSum += square[outer][inner]; //Add row sum (-)
				colSum += square[inner][outer]; //Add column sum (|)
			
			}
			//System.out.println("Row "+outer+" sum: "+rowSum);
			//System.out.println("Column "+outer+" sum: "+colSum);
			if (outer == 0) magicNum = rowSum; //Set magic number the first time.
			if (rowSum != magicNum) return false;
			if (colSum != magicNum) return false;
			
		}
		//System.out.println("\\ Sum: "+negSum);
		//System.out.println("/ Sum:  "+posSum);
		if (negSum != magicNum) return false;
		if (posSum != magicNum) return false;
		
		return true;
	}
	
	public static void main( String[] args) {
		
		System.out.println("0 is heteromecic: "+isHeteromecic(0));
		System.out.println("2 is heteromecic: "+isHeteromecic(2));
		System.out.println("7 is heteromecic: "+isHeteromecic(7));
		System.out.println("110 is heteromecic: "+isHeteromecic(110));
		System.out.println("136 is heteromecic: "+isHeteromecic(136));
		System.out.println("156 is heteromecic: "+isHeteromecic(156));
		
		System.out.println();
		
		System.out.println("203 is happy: "+happy(203));
		System.out.println("11 is happy: "+happy(11));
		System.out.println("107 is happy: "+happy(107));
		System.out.println("860 is happy: "+happy(860));
		
		System.out.println();
		
		System.out.println("75 is disarium: "+is_disarium(75));
		System.out.println("135 is disarium: "+is_disarium(135));
		System.out.println("544 is disarium: "+is_disarium(544));
		System.out.println("518 is disarium: "+is_disarium(518));
		System.out.println("466 is disarium: "+is_disarium(466));
		System.out.println("8 is disarium: "+is_disarium(8));
		
		System.out.println();
		
		System.out.println("apple in atbash: "+atbash("apple"));
		System.out.println("Hello World! in atbash: "+atbash("Hello World!"));
		System.out.println("Christmas is the 25th of December in atbash: "+atbash("Christmas is the 25th of December"));
		System.out.println("Aa Bb Cc Dd Ee ... Zz Yy Xx Ww Vv in atbash: "+atbash("Aa Bb Cc Dd Ee ... Zz Yy Xx Ww Vv"));
		
		System.out.println();
		
		int[][] a3square = new int[][] {
			{ 2, 7, 6 },
			{ 9, 5, 1 },
			{ 4, 3, 8 }
			};
			System.out.println(Arrays.deepToString(a3square)+" is a magic square: "+isMagicSquare(a3square));
		
		int[][] a4square = new int[][] {
			{ 16, 3, 2, 13 },
			{ 5, 10, 11, 8 },
			{ 9, 6, 7, 12 },
			{ 4, 15, 14, 1 }
			};
			System.out.println(Arrays.deepToString(a4square)+" is a magic square: "+isMagicSquare(a4square));
		
		int[][] another4square = new int[][] {
				{ 1, 14, 14, 4 },
				{ 11, 7, 6, 9 },
				{ 8, 11, 10, 5 },
				{ 13, 2, 3, 15 }
				};
				System.out.println(Arrays.deepToString(another4square)+" is a magic square: "+isMagicSquare(another4square));
		
		int[][] fixed4square = new int[][] {
			{ 1, 14, 15, 4 },
			{ 12, 7, 6, 9 },
			{ 8, 11, 10, 5 },
			{ 13, 2, 3, 16 }
			};
			System.out.println(Arrays.deepToString(fixed4square)+" is a magic square: "+isMagicSquare(fixed4square));
					
	}
	
}
