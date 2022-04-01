package MicroThings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultCube {
	
	public static void main(String[] args) throws IOException {
		
		
		String myPath = "C:\\MultiplicationTableFiles\\";
		
		System.out.println("Files are being stored and read in this location: "+myPath);
		
		//Create the files needed to write files	
		File occurFrequentFile = new File(myPath+"b057338-CUBE-NumberOfOccurrences.txt");
		occurFrequentFile.createNewFile();
		FileWriter occurFrequentWriter = new FileWriter(occurFrequentFile);
		
		File largestFrequentFile = new File(myPath+"b057339-CUBE-LargestOfMostFrequent.txt");
		largestFrequentFile.createNewFile();
		FileWriter largestFrequentWriter = new FileWriter(largestFrequentFile);
		
		File smallestFrequentFile = new File(myPath+"b057340-CUBE-SmallestOfMostFrequent.txt");
		smallestFrequentFile.createNewFile();
		FileWriter smallestFrequentWriter = new FileWriter(smallestFrequentFile);
		
		File numberFrequentFile = new File(myPath+"bXXX-CUBE-NumberOfMostFrequent.txt");
		numberFrequentFile.createNewFile();
		FileWriter numberFrequentWriter = new FileWriter(numberFrequentFile);
	
	for (int c=1; c<=500; c++) {
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
	System.out.println(c+" Count: "+hicount+" Smallest: "+smallest+" Largest: "+largest+" Total: "+total);
	
	occurFrequentWriter.write(c+" "+hicount+"\n");	
	largestFrequentWriter.write(c+" "+largest+"\n");
	smallestFrequentWriter.write(c+" "+smallest+"\n");
	numberFrequentWriter.write(c+" "+total+"\n");
	
	}
	
	
	occurFrequentWriter.flush();
	occurFrequentWriter.close();
	
	largestFrequentWriter.flush();
	largestFrequentWriter.close();
	
	smallestFrequentWriter.flush();
	smallestFrequentWriter.close();

	numberFrequentWriter.flush();
	numberFrequentWriter.close();
	
	doubleCheck(myPath,"b057338-CUBE-NumberOfOccurrences.txt","b057338.txt");	
	doubleCheck(myPath,"b057339-CUBE-LargestOfMostFrequent.txt","b057339.txt");
	doubleCheck(myPath,"b057340-CUBE-SmallestOfMostFrequent.txt","b057340.txt");
	
	
}
	
	private static boolean doubleCheck(String directory, String actual, String expected) throws IOException {
		
		FileReader actualFR = new FileReader(directory+actual);
		BufferedReader actualFile = new BufferedReader(actualFR);
		
		FileReader expectedFR = new FileReader(directory+expected);
		BufferedReader expectedFile = new BufferedReader(expectedFR);
		
		String nextLine = "0 -1";
		int[] expectedValues = new int[20010];
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
	
}
