package WeeklyCodingChallenges;

public class WeekDecember13 {
	
	public static void main(String[] args) {
		
		//System.out.println(AlmostPal("abccgba"));
		
		System.out.println(StepCounter(8));
		
	}
	
	static int totalSteps;
	
	static boolean AlmostPal(String text) {
		
		//Loop through half of the string
		int half = text.length();
		if (text.length() % 2 == 1) half++;  //add 1 if an odd number
		half = half / 2;
		
		int bad=0;
		for (int i=0; i<half; i++) {
			char left = text.charAt(i);
			char right = text.charAt(text.length()-(1+i));
			
			if (left != right) bad++;
			System.out.println(left+" "+right);
		}
		
		return (bad == 1 ? true : false);
		
	}
	
	static int StepCounter (int numSteps ){
		
		
		CountSteps(numSteps);
		
		return totalSteps;
		
	}
	
	static void CountSteps(int number) {
		
		if (number==0) {
			totalSteps++;
		}
		
		if (number==1) {
			totalSteps++;
		}
		
		if (number>=2) {
			CountSteps(number-2);
			CountSteps(number-1);
		}
		
	}

}
