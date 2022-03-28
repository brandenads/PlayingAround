package MyStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class multTable {

	public static void main(String[] args) throws IOException {
		
		
		//largest size of the multiplication table (value of n)
		int maxTable = 100; 
		
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
		
		String myPath = "C:\\Users\\brand\\git\\PlayingAround\\PlayAround\\src\\main\\java\\MyStuff\\MultiplicationTableFiles\\";
		
		File occurFrequentFile = new File(myPath+"NumberOfOccurrences.txt");
		occurFrequentFile.createNewFile();
		FileWriter occurFrequentWriter = new FileWriter(occurFrequentFile);
		
		//Print location of output file
		System.out.println("Files are being stored in the following location: "+myPath);

		
		File listFrequentFile = new File(myPath+"ListOfMostFrequent.txt");
		listFrequentFile.createNewFile();
		FileWriter listFrequentWriter = new FileWriter(listFrequentFile);
		
		File largestFrequentFile = new File(myPath+"LargestOfMostFrequent.txt");
		largestFrequentFile.createNewFile();
		FileWriter largestFrequentWriter = new FileWriter(largestFrequentFile);
		
		File smallestFrequentFile = new File(myPath+"SmallestOfMostFrequent.txt");
		smallestFrequentFile.createNewFile();
		FileWriter smallestFrequentWriter = new FileWriter(smallestFrequentFile);
		
		File numberFrequentFile = new File(myPath+"NumberOfMostFrequent.txt");
		numberFrequentFile.createNewFile();
		FileWriter numberFrequentWriter = new FileWriter(numberFrequentFile);
		
		File onlyOnceFile = new File(myPath+"OccurringOnlyOnce.txt");
		onlyOnceFile.createNewFile();
		FileWriter onlyOnceWriter = new FileWriter(onlyOnceFile);
		
		File moreThanOnceFile = new File(myPath+"OccurringMoreThanOnce.txt");
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
		
		System.out.println();
		
		
		//Test the results for sequences already in the OEIS
		doubleCheck(myPath,"NumberOfMostFrequent.txt","NumberOfMostFrequent-b064048.txt");
		doubleCheck(myPath,"LargestOfMostFrequent.txt","LargestOfMostFrequent-b057143.txt");
		doubleCheck(myPath,"NumberOfMostFrequent.txt","NumberOfMostFrequent-b064048.txt");
		doubleCheck(myPath,"NumberOfOccurrences.txt","NumberOfOccurrences-b057142.txt");
		doubleCheck(myPath,"OccurringOnlyOnce.txt","OccurringOnlyOnce-b064047.txt");
		doubleCheck(myPath,"SmallestOfMostFrequent.txt","SmallestOfMostFrequent-b057144.txt");
		
		//The number of terms occurring more than once is not in the OEIS.
		//But the number of distinct terms is in the OEIS.
		//To check this, check the truth of the following equation:
		// (numbers that occur once) + (numbers that occur more than once) = (number of distinct terms)
		moreThanOnceCheck(myPath,"OccurringMoreThanOnce.txt","OccurringOnlyOnce.txt","NumberOfDistinctTerms-b027424.txt", 10000);
		
	} //end of main
	
	private static boolean moreThanOnceCheck(String directory, String moreThanOnce, String onlyOnce, String distinctTerms, int maxiVal) throws IOException {
		
		FileReader moreThanOnceFR = new FileReader(directory+moreThanOnce);
		BufferedReader moreThanOnceFile = new BufferedReader(moreThanOnceFR);
		
		FileReader onlyOnceFR = new FileReader(directory+onlyOnce);
		BufferedReader onlyOnceFile = new BufferedReader(onlyOnceFR);
		
		FileReader distinctTermsFR = new FileReader(directory+distinctTerms);
		BufferedReader distinctTermsFile = new BufferedReader(distinctTermsFR);
		
		int[] moreThanOnceValues = new int[10010];
		int[] onlyOnceValues = new int[10010];
		int[] distinctTermsValues = new int[10010];
		
		String nextLine = "0 -1";
		
		//Read in all three files, and save to arrays.
		while ((nextLine = moreThanOnceFile.readLine()) != null) {
			
			//Parse read line into integers
			String[] lineVals = nextLine.split(" ");
			int index = Integer.parseInt(lineVals[0]);
			int value = Integer.parseInt(lineVals[1]);
			
			moreThanOnceValues[index] = value;
			
		}

		while ((nextLine = onlyOnceFile.readLine()) != null) {
			
			//Parse read line into integers
			String[] lineVals = nextLine.split(" ");
			int index = Integer.parseInt(lineVals[0]);
			int value = Integer.parseInt(lineVals[1]);
			
			onlyOnceValues[index] = value;
			
		}
		
		while ((nextLine = distinctTermsFile.readLine()) != null) {
			
			//Parse read line into integers
			String[] lineVals = nextLine.split(" ");
			int index = Integer.parseInt(lineVals[0]);
			int value = Integer.parseInt(lineVals[1]);
			
			distinctTermsValues[index] = value;
			
		}
		
		
		//Check to see if the formula is true: (numbers that occur once) + (numbers that occur more than once) = (number of distinct terms)
		for(int i=1; i<=maxiVal; i++) {
			
			//Make sure tests do not fail simply do to a lack of input data by checking that none of the numbers are zero.
			if (moreThanOnceValues[i] != 0 && onlyOnceValues[i] != 0 && distinctTermsValues[i] != 0) {
			if (moreThanOnceValues[i] + onlyOnceValues[i] != distinctTermsValues[i]) {
				
				System.out.print("The "+moreThanOnce+" double check test FAILED. ");
				System.out.println("Index: "+i+" more than once: "+moreThanOnceValues[i]+" only once: "+onlyOnceValues[i]+" distinct: "+distinctTermsValues[i]+" add: "+(moreThanOnceValues[i]+onlyOnceValues[i]));
				
				distinctTermsFile.close();
				distinctTermsFR.close();
				moreThanOnceFile.close();
				moreThanOnceFR.close();
				onlyOnceFile.close();
				onlyOnceFR.close();
				
				return false;
			}
		}
		}
		
		distinctTermsFile.close();
		distinctTermsFR.close();
		moreThanOnceFile.close();
		moreThanOnceFR.close();
		onlyOnceFile.close();
		onlyOnceFR.close();
		
		System.out.print("The "+moreThanOnce+" double check test PASSED. ");
		
		return true;
		
	}
	
	private static boolean doubleCheck(String directory, String actual, String expected) throws IOException {
		
		FileReader actualFR = new FileReader(directory+actual);
		BufferedReader actualFile = new BufferedReader(actualFR);
		
		FileReader expectedFR = new FileReader(directory+expected);
		BufferedReader expectedFile = new BufferedReader(expectedFR);
		
		String nextLine = "0 -1";
		int[] expectedValues = new int[10010];
		int indexExpected = 0;
		
		
		//Get rid of pound signs at top of file
		while ((nextLine = expectedFile.readLine()).substring(0, 1).equals("#")) {}
		
		//Get first value already read
		expectedValues[Integer.parseInt(nextLine.split(" ")[0])] = Integer.parseInt(nextLine.split(" ")[1]);
		
		//Store array of expected values
		while ((nextLine = expectedFile.readLine()) != null) {
			
			//Parse read line into integers
			String[] lineVals = nextLine.split(" ");
			indexExpected = Integer.parseInt(lineVals[0]);
			int value = Integer.parseInt(lineVals[1]);
			
			//Store value into array
			expectedValues[indexExpected] = value;
			
		}
		
		//Compare expected values to actual values
		while ((nextLine = actualFile.readLine()) != null) {
		
			//Parse read line into integers
			String[] lineVals = nextLine.split(" ");
			int index = Integer.parseInt(lineVals[0]);
			int value = Integer.parseInt(lineVals[1]);
			
			//Compare actual data to expected data.
			//Skip zero values in expected values array, as this simply means there is
			//no expected value for this number
			if( expectedValues[index] > 0) {
				
				//If the actual value does not match the expected value, then the test is a FAIL.
				if( expectedValues[index] != value) {
					
					System.out.println("The "+actual+" double check has FAILED.");
					System.out.println("Index: "+index+" Expected: "+expectedValues[index]+" Actual: "+value);
					
					actualFile.close();
					expectedFile.close();
					actualFR.close();
					expectedFR.close();
					
					return false;
				}
				
			}
		}

		actualFile.close();
		expectedFile.close();
		actualFR.close();
		expectedFR.close();
		
		System.out.println("The "+actual+" double check has PASSED.");
		return true;
	}
	
} //end of class
