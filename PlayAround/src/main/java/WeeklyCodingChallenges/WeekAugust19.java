package WeeklyCodingChallenges;

public class WeekAugust19 {

	public static boolean isPalindrome (String S) {
		
		int[] asciiValues = new int[256];
		for(int i=0; i<S.length(); i++) {
			asciiValues[S.charAt(i)]++;
		}
		
		//For a palindrome to be possible, all letters must occur an even
		//numbered amount of times, with only one (or none) occurring an odd
		//number of times. If 2 or more letters are found occurring an odd number of times,
		//then it is not a palindrome.
		int oddNumbers = 0;
		for(int a : asciiValues) {
			if (a % 2 == 1) oddNumbers++;
			if (oddNumbers == 2) break;
		}
		
		if (oddNumbers < 2) return true;
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("racecar"));		//true
		System.out.println(isPalindrome("suhbeusheff"));	//true
		System.out.println(isPalindrome("PalinDrome"));		//false
		
	}
}
