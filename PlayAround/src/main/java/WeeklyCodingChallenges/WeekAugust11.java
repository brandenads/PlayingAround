package WeeklyCodingChallenges;

public class WeekAugust11 {
	
	static int quadraticEquation(int a, int b, int c) {
		
		double da = (double) a;
		double db = (double) b;
		double dc = (double) c;
		
		double x = (-db + Math.sqrt((db*db) - (4*da*dc)))/(2*da);
		
		return (int) x;
	}
	
	static void qeHelper(int a, int b, int c) {
		//Helper function to print out results of Quadratic Equation function
		System.out.println("The solution to "+a+"x^2 + "+b+"x + "+c+" = 0 is "+quadraticEquation(a,b,c));
		
	}
	
	static boolean checkPerfect (int n) {
		
		int total = 0;
		for(int i=1; i<n; i++) {
			if (n % i == 0) total += i;
		}
		
		if (total == n ) return true;
		return false;
	}

	static void pHelper (int n) {
		//Helper function to print out the output of perfect numbers
		System.out.println("The number "+n+" is"+(checkPerfect(n) ? "" : " not")+" perfect");
	}
	public static void main(String[] args) {
		
		qeHelper(1,2,-3); // 1
		qeHelper(2,-7,3); // 3
		qeHelper(1,-12,-28); // 14
		
		pHelper(6); //true
		pHelper(28); //true
		pHelper(496); //true
		pHelper(12); //false
		pHelper(97); //false
	}
	
	

}
