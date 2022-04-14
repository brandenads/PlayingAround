package MicroThings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultCube22 {
	
	static int high; 
	static int low;
	static int highestFrequency = 0;
	static int[] counters;
	
	public static void main(String[] args) throws IOException {
		
	
	for (int c=1; c<=100; c++) {
	int hicount=0;
	int smallest = 0; int largest=0;
	int total=0;
	int[] mc = new int[(c*c*c)+1];
	for(int i=1; i<=c; i++)
		for(int j=1; j<=c; j++)
			for(int k=1; k<=c; k++) {
				int mult = i*j*k;
				//System.out.println("c is"+c);
				mc[mult]++;
				if (mc[mult] > hicount) {
					hicount = mc[mult];
				}
			}
	for(int m=1; m<=c*c*c; m++) {
		if(mc[m] == hicount) {
			if(m > largest) largest = m;
			if(smallest==0 || m < smallest) smallest = m;
			total++;
		}
	}
	
	//System.out.println(c+" Count: "+hicount+" Smallest: "+smallest+" Largest: "+largest+" Total: "+total);
	System.out.println(c+" "+smallest);
	

	
	}
	
	
	int max=100; //the number of terms to generate

	counters = new int[max*max*max+1];
	for(int c=1; c<=max; c++) {
		//System.out.println(c+" "+c+" "+c+" -> special (c,c,c)");
		set(c*c*c,1);
		for(int outer=c-1; outer>=1; outer--) {
			//System.out.println(c+" "+c+" "+outer+" -> special (c,c,outer)");
			set(c*c*outer,3);
			//System.out.println(c+" "+outer+" "+outer+" -> special (c,outer,outer)");
			set(c*outer*outer,3);
			for(int inner=outer-1; inner>=1; inner--) {
				//System.out.println(c+" "+outer+" "+inner);
				set(c*outer*inner,6);
			}
		}
		System.out.println(c+" "+low);	
	}

	
} //main

	private static void set(int number, int repeatFactor) {
		counters[number] += repeatFactor;
		if(counters[number] >= highestFrequency) {
			if (counters[number] == highestFrequency) {
				if (number > high) high = number;
				if (number < low) low = number;
			}
			if(counters[number] > highestFrequency) {
				highestFrequency = counters[number];
				high = number;
				low = number;
			}
		}
	}
	
} //class
