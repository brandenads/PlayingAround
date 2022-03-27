package MyStuff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class multTable {

	public static void main(String[] args) throws IOException {
		
		
		//largest size of the multiplication table (value of n)
		int maxTable = 10000; 
		
		//Variables for number frequency counters
		int occurFrequent=0;	//Number of occurrences of the most frequent number in the table
		String listFrequent="";	//A list of most frequent numbers in the table
		int largestFrequent=0;	//Largest of the most frequent numbers in the table
		int smallestFrequent=0;	//Smallest of the most frequent numbers in the table
		int numberFrequent=0;	//Count of how many numbers are most frequent in the table
		int onlyOnce=0;			//Count of numbers occurring only once
		int moreThanOnce=0;		//Count of numbers occurring more than once
		
		int[] numberCount = new int[(maxTable * maxTable) +1];
		
		//Create the files needed to write files
		File occurFrequentFile = new File("NumberOfOccurrences.txt");
		occurFrequentFile.createNewFile();
		FileWriter occurFrequentWriter = new FileWriter(occurFrequentFile);
		
		//Print locaton of output file
		System.out.println("Files are being stored in the following location:");
		String path = occurFrequentFile.getAbsolutePath();
		System.out.println(path.substring(0, path.length()-24));

		
		File listFrequentFile = new File("ListOfMostFrequent.txt");
		listFrequentFile.createNewFile();
		FileWriter listFrequentWriter = new FileWriter(listFrequentFile);
		
		File largestFrequentFile = new File("LargestOfMostFrequent.txt");
		largestFrequentFile.createNewFile();
		FileWriter largestFrequentWriter = new FileWriter(largestFrequentFile);
		
		File smallestFrequentFile = new File("SmallestOfMostFrequent.txt");
		smallestFrequentFile.createNewFile();
		FileWriter smallestFrequentWriter = new FileWriter(smallestFrequentFile);
		
		File numberFrequentFile = new File("NumberOfMostFrequent.txt");
		numberFrequentFile.createNewFile();
		FileWriter numberFrequentWriter = new FileWriter(numberFrequentFile);
		
		File onlyOnceFile = new File("OccurringOnlyOnce.txt");
		onlyOnceFile.createNewFile();
		FileWriter onlyOnceWriter = new FileWriter(onlyOnceFile);
		
		File moreThanOnceFile = new File("OccurringMoreThanOnce.txt");
		moreThanOnceFile.createNewFile();
		FileWriter moreThanOnceWriter = new FileWriter(moreThanOnceFile);
		
		
		//Print progress counter.
		System.out.print("Starting: 0%");
		
		//Iterate the size of the multiplication table (n)
		for(int currentSize=1; currentSize<=maxTable; currentSize++) {
			
			//Erase only enough of the numberCount array as needed.
			for(int ee=1; ee<=(currentSize*currentSize); ee++)
				numberCount[ee]=0;
				
			//Count the number of times each number appears in the nxn multiplication table
			for (int i=1; i<=currentSize; i++)
				for (int j=1; j<=currentSize; j++)
					numberCount[i*j]++;

			
			//Reset the number frequency counters
			occurFrequent=0;	//Number of occurrences of the most frequent number in the table
			listFrequent="";	//A list of most frequent numbers in the table
			largestFrequent=0;	//Largest of the most frequent numbers in the table
			smallestFrequent=0;	//Smallest of the most frequent numbers in the table
			numberFrequent=0;	//Count of how many numbers are most frequent in the table
			onlyOnce=0;			//Count of numbers occurring only once
			moreThanOnce=0;		//Count of numbers occurring more than once

			
			//First, find the number of times the most frequent number appears
			for(int k=1; k<=(currentSize*currentSize); k++)
				if (numberCount[k] > occurFrequent) occurFrequent = numberCount[k];
			
			//Second, collect counts for the multiplication table
			for(int m=1; m<=(currentSize*currentSize); m++) {
				
				//Find the amount of numbers occurring only once
				if (numberCount[m] == 1) onlyOnce++;
				
				//Find the amount of numbers occurring more than once.
				if (numberCount[m] > 1) moreThanOnce++; 
				
				//Find statistics on the most frequently occurring numbers
				if (numberCount[m] == occurFrequent) {
					
					//List most frequently occurring numbers
					listFrequent = listFrequent.concat(Integer.toString(m))+", ";
					
					//Count the number of most frequently occurring numbers
					numberFrequent++;
					
					//Find the largest of the most frequent numbers
					if(m > largestFrequent) largestFrequent = m;
					
					//Find the smallest of the most frequent numbers
					if(smallestFrequent == 0 || m < smallestFrequent) smallestFrequent = m;
				}
			}
			
			//Print progress counter. (fixed for 10,000 total)
			if(currentSize % 100 == 0 ) 
				System.out.print("..."+currentSize/100+"%");
			if(currentSize % 1000 == 0)
				System.out.println();
			
			
			occurFrequentWriter.write(currentSize+" "+occurFrequent+"\n");		
			//System.out.println("[Occurrences of most frequent] "+currentSize+" "+occurFrequent);
			//System.out.println(currentSize+" "+occurFrequent);
			
			listFrequent=listFrequent.substring(0,listFrequent.length()-2);   //Remove last comma
			listFrequentWriter.write(currentSize+" --> "+listFrequent+"\n");
			//System.out.println(currentSize+" "+listFrequent+"\n");
			
			largestFrequentWriter.write(currentSize+" "+largestFrequent+"\n");
			//System.out.println(numberFrequent+" [largest most frequent] "+currentSize+" "+largestFrequent);	
			//System.out.println(currentSize+" "+largestFrequent);
						
			smallestFrequentWriter.write(currentSize+" "+smallestFrequent+"\n");
			//System.out.println(numberFrequent+" [smallest most frequent] "+currentSize+" "+smallestFrequent);	
			//System.out.println(currentSize+" "+smallestFrequent);		
			
			numberFrequentWriter.write(currentSize+" "+numberFrequent+"\n");
			//System.out.println(occurFrequent+" [Number of most frequent] "+currentSize+" "+numberFrequent+" list: "+listFrequent);
			//System.out.println(currentSize+" "+numberFrequent);
			
			onlyOnceWriter.write(currentSize+" "+onlyOnce+"\n");
			//System.out.println("[numbers occurring only once] "+currentSize+" "+onlyOnce);
			//System.out.println(currentSize+" "+onlyOnce);
			
			moreThanOnceWriter.write(currentSize+" "+moreThanOnce+"\n");
			

				
		}
		
		
		//Close the files
		occurFrequentWriter.flush();
		occurFrequentWriter.close();
		
		listFrequentWriter.flush();
		listFrequentWriter.close();
			
		largestFrequentWriter.flush();
		largestFrequentWriter.close();
		
		smallestFrequentWriter.flush();
		smallestFrequentWriter.close();

		numberFrequentWriter.flush();
		numberFrequentWriter.close();
		
		onlyOnceWriter.flush();
		onlyOnceWriter.close();
		
		moreThanOnceWriter.flush();
		moreThanOnceWriter.close();
}
	
}
