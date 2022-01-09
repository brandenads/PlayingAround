package MyStuff;

public class NoRepeatPrimes {
	
	public static void main(String[] args) {
		
		int[] repCount = new int[10];
		int repeat=0; int index; int prime; int overDigit;
		
		for (long number=987654321L; number>=123456789L; number--) {
		//for (int number=213456902; number<=213456912; number++) {
			
			//see if the number itself has repeating digits
			String iStr = String.valueOf(number);			
			repeat=0; overDigit=0;
			for(int a=0; a<10; a++) { repCount[a]=0;}
			for(int t=0; t<iStr.length(); t++) {
				index=Character.getNumericValue(iStr.charAt(t));
				repCount[index]++;
				if (repCount[index] > 1) repeat=1;
				//if(index==0 || index>iStr.length()) overDigit=1;
				//if(index==0) overDigit=1; //keeps the zero out
				//System.out.println("Index: "+index);
			}
			//System.out.println("Number above is: "+number);
			
			//if(repeat==0 && overDigit==0)
			//System.out.println("Number: "+number+" Repeat: "+repeat+" Digit too large: "+overDigit);
			
		//If the number has no repeating digits, see if it is prime
		
		if (repeat==0 && overDigit==0) {
			prime=1;
			for (long p=2L; p<number; p++) {
				if (number % p == 0) {prime=0; break;}
			}
			
			if (prime == 1)
			System.out.println("Number: "+number+" Repeat: "+repeat+" prime: "+prime+ " Digit too large "+overDigit);		
			
		} 
		
		if(number % 50000000L == 0 ) System.out.println(number+" Still going...");
		
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
