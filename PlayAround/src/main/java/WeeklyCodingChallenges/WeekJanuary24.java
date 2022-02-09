package WeeklyCodingChallenges;

import java.util.HashMap;
import java.util.Map;

public class WeekJanuary24 {
	
	public static boolean validate(String input) {
		
		return input.matches("^(\\d{4}|\\d{6})$");
	}
	
	public static String interview(int[] questions, int total) {
		
		//See if the total time of the interview was too long
		if (total > 120) return "disqualified";
		
		//Check if all questions are answered, by seeing if there are 8 elements
		if (questions.length < 8) return "disqualified";
		
		//See if any of the questions took too long
		int [] maxTime = new int[] {5,5,10,10,15,15,20,20};
		for ( int i=0; i<8; i++)
			if (questions[i] > maxTime[i]) return "disqualified";
		
		return "qualified";
	}
	
	public static String encrypt( String plaintext) {
		
		//Create a StringBuilder for manipulation of strings
		StringBuilder ciphertext = new StringBuilder().append(plaintext);
		
		//Reverse the string
		ciphertext.reverse();
		
		//Replace vowels
		Map<Character, String> vowels = new HashMap<Character, String>();
		vowels.put('a', "0");
		vowels.put('e', "1");
		vowels.put('i', "2");
		vowels.put('o', "2");
		vowels.put('u', "3");
		for (int i=0; i<ciphertext.length(); i++) {
			char letter = ciphertext.charAt(i);	
			if (vowels.containsKey(letter))
				ciphertext.replace(i, i+1, vowels.get(letter));	
		}
		
		//add "aca"
		ciphertext.append("aca");
		
		return ciphertext.toString();
	}

	public static void main(String[] args) {
		
		System.out.println("Interview Questions");
		System.out.println(interview(new int [] { 5, 5, 10, 10, 15, 15, 20, 20 }, 120));
		System.out.println(interview(new int [] { 2, 3, 8, 6, 5, 12, 10, 18 }, 64) );
		System.out.println(interview(new int [] { 5, 5, 10, 10, 25, 15, 20, 20 }, 120));
		System.out.println(interview(new int [] { 5, 5, 10, 10, 15, 15, 20 }, 120));
		System.out.println(interview(new int [] { 5, 5, 10, 10, 15, 15, 20, 20 }, 130));
		
		System.out.println("Encryption");
		System.out.println(encrypt("apple"));
		System.out.println(encrypt("banana"));
		System.out.println(encrypt("karaca"));
		System.out.println(encrypt("burak"));
		System.out.println(encrypt("alpaca"));
		
		System.out.println("Password Validation");
		System.out.println(validate("121317"));
		System.out.println(validate("1234"));
		System.out.println(validate("45135"));
		System.out.println(validate("89abc1"));
		System.out.println(validate("900876"));
		System.out.println(validate(" 4983"));
	}
}
