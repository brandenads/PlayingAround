package MicroThings;

public class LargestMultCube {
	static int high, low, highestFrequency = 0; 
	static int[] counters;
	public static void main(String[] args) {
	int max=500; 
	counters = new int[max*max*max+1];
	for(int outer=1; outer<=max; outer++) {
		tally(outer*outer*outer,1);
		for(int middle=outer-1; middle>=1; middle--) {
			tally(outer*outer*middle,3); tally(outer*middle*middle,3);
			for(int inner=middle-1; inner>=1; inner--) {
				tally(outer*middle*inner,6); } }
		System.out.println(outer+" "+high);	} } 
	private static void tally(int number, int repeatFactor) {
		counters[number] += repeatFactor;
		if(counters[number] >= highestFrequency) {
			if (counters[number] == highestFrequency) 
				if (number > high) high = number;
			if (counters[number] > highestFrequency) {
				highestFrequency = counters[number]; high = number; } } } }