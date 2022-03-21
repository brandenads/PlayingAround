package MyStuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class multTable {

	public static void main(String[] args) {
		
		int maxTable = 1000; //largest size of the multiplication table
		int tableSize = maxTable*maxTable;
		int occurFrequent = 0;
		String listFrequent = "";
		int numberFrequent = 0;
		int onlyOnce = 0;
		int largestFrequent=0;
		int smallestFrequent=0;
		int moreThanOnce=0;
		
		int[] numberCount = new int[tableSize+1];
		
		for(int currentSize=1; currentSize<=maxTable; currentSize++) {
			
			for(int ee=1; ee<=(currentSize*currentSize); ee++)
				numberCount[ee]=0;
				
				
			for (int i=1; i<=currentSize; i++)
				for (int j=1; j<=currentSize; j++)
					numberCount[i*j]++;
		
			//Functions go here
			
			//Find the most frequently occurring number in the table.
			occurFrequent=0;
			listFrequent="";
			numberFrequent=0;
			onlyOnce=0;
			moreThanOnce=0;
			largestFrequent=0;
			smallestFrequent=0;
			
			//First, find the number of times the most frequent number appears
			for(int k=1; k<=(currentSize*currentSize); k++)
				if (numberCount[k] > occurFrequent) occurFrequent = numberCount[k];
			
			//Second, collect statistics on the number counts
			for(int m=1; m<=(currentSize*currentSize); m++) {
				
				//Find the amount of numbers occurring only once
				if (numberCount[m] == 1) onlyOnce++;
				
				//Find the amount of numbers occurring more than once.
				if (numberCount[m] > 1) moreThanOnce++; 
				
				//Find statistics on the most frequently occurring numbers
				if (numberCount[m] == occurFrequent) {
					
					//List most frequently occurring numbers
					listFrequent = listFrequent.concat(Integer.toString(m))+" ";
					
					//Count the number of most frequently occurring numbers
					numberFrequent++;
					
					//Find the largest of the most frequent numbers
					if(m > largestFrequent) largestFrequent = m;
					
					//Find the smallest of the most frequent numbers
					if(smallestFrequent == 0 || m < smallestFrequent) smallestFrequent = m;
				}
			}
			
			//System.out.println("[Occurrences of most frequent] "+currentSize+" "+occurFrequent);
			//System.out.println(currentSize+" "+occurFrequent);
			
			//System.out.println(occurFrequent+" [Number of most frequent] "+currentSize+" "+numberFrequent+" list: "+listFrequent);
			//System.out.println(currentSize+" "+numberFrequent);
				
			//System.out.println("[numbers occurring only once] "+currentSize+" "+onlyOnce);
			//System.out.println(currentSize+" "+onlyOnce);
			
			//System.out.println(numberFrequent+" [largest most frequent] "+currentSize+" "+largestFrequent);	
			//System.out.println(currentSize+" "+largestFrequent);
			
			//System.out.println(numberFrequent+" [smallest most frequent] "+currentSize+" "+smallestFrequent);	
			//System.out.println(currentSize+" "+smallestFrequent);
				
		}
		

	
}
	
}
