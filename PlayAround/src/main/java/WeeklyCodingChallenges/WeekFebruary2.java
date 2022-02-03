package WeeklyCodingChallenges;

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
		
	}
	
	
	
}
