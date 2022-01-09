package MyStuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DuoSquare {


	public static void doubleSquare (String [] words) {
		
		char[][] currentSquare = new char[5][5];
		for(int topWord=0; topWord < words.length; topWord++) {
			
			//Put top word in
			for(int fillTop=0; fillTop<words[0].length(); fillTop++) {
				currentSquare[0][fillTop] = words[topWord].charAt(fillTop);
			}
			
			//Fill subsequent lines
			fillSquareRecurse(1, currentSquare, words);
			//break;
			
			//printSquare(currentSquare);
		}
		
	}
	
	private static void fillSquareRecurse (int level, char[][] squareSoFar, String[] wordList ) {
		
		//Traverse word list
		int validity;
		for(int rowWord=0; rowWord<wordList.length; rowWord++) {
			
			//Check if the next word is compatible with the current word in the list.
			//Getting the letters of the net word
			validity=0;
			for(int wordChar=0; wordChar<wordList[0].length(); wordChar++) {
				StringBuilder stub = new StringBuilder("");
				
				//Create the prefix stub
				for(int above=0; above<level; above++)
					stub.append(squareSoFar[above][wordChar]);
				stub.append(wordList[rowWord].charAt(wordChar));
				//System.out.println("stub is "+stub);
				
				//traverse word list to find if any other word have this prefix
				for(int findStub=0; findStub<wordList.length; findStub++)
					if (wordList[findStub].substring(0, level+1).equals(stub.toString())) {
						validity++;
						break; //break for findStub for loop
					} //end of if statement
			} //end of wordChar for statement
			
			//If the word is valid, add it to the square and continue to the next level
			if(validity==wordList[0].length()) {
				for(int inSquare=0; inSquare<wordList[0].length(); inSquare++)
					squareSoFar[level][inSquare] = wordList[rowWord].charAt(inSquare);
				
				//If it is complete, return.
				if(level==wordList[0].length()-1) {
					System.out.println("======================================= A complete square is...");
					printSquare(squareSoFar);
					return;
				}
				
				//If it is incomplete, recurse.
				if(level < wordList[0].length()-1) {
					int nextlevel = level + 1;
					
					System.out.println("in com plete");
					
				    //Cleanout next levels, for readable debugging
					for(int cleanlev=nextlevel; cleanlev<wordList[0].length(); cleanlev++)
						for(int cleanout=0;cleanout<wordList[0].length(); cleanout++)
							squareSoFar[cleanlev][cleanout]=' ';
					
				    printSquare(squareSoFar);
				    
				    if (nextlevel<5) //debug stop
				    	fillSquareRecurse(nextlevel, squareSoFar, wordList);
				} 
				
				//break; //debug break for rowWords for loop.
			} 
			
			
			//for debugging
			//printSquare(squareSoFar);
			 
		}
	}
	
	
	
	
	private static void printSquare (char [][] squareToPrint) {
		for(int x=0; x<2+squareToPrint[0].length; x++) System.out.print("+");
		System.out.println("");
		for(int i=0; i<squareToPrint[0].length; i++)  {
			System.out.print("+");
			for (int j=0; j<squareToPrint[0].length; j++)
				System.out.print(squareToPrint[i][j]);
			System.out.println("+");
		}
		for(int x=0; x<2+squareToPrint[0].length; x++) System.out.print("+");
		System.out.println("");
	}

		
	
	public static void main( String[] args) {
		
		int WordSquareSize = 5;
		
	    int total=0;
	    ArrayList<String> WordList = new ArrayList<String>();

    try {
    //File myObj = new File("c:\\javafiles\\web2.txt"); 
    File myObj = new File("c:\\javafiles\\NPLCombinedWordList.txt");
      Scanner myReader = new Scanner(myObj);
     while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        
        //Prevents repeating letters 
        /*
        if (data.length() == WordSquareSize && data.toLowerCase().equals(data)) {
        	int [] asciiVal = new int[128];
        	int t=0;
        	for(t=0;t<data.length();t++) {
        		int ascii = data.charAt(t);
        		asciiVal[ascii]++;
        		if (asciiVal[ascii]==2) break;
        	}
        	if (t == data.length()) {
        	   	System.out.println(data);
        	   	WordList.add(data);
        	   	total++;
        	}
        }   
        */
        int goodChars=0;
        for(goodChars=0; goodChars<data.length(); goodChars++) {
        	int ascii = data.charAt(goodChars);
        	if (ascii > 122 || ascii < 97) break;
        }
        if (goodChars == data.length() && data.length() == WordSquareSize) {
    	   	System.out.println(data);
    	   	WordList.add(data);
    	   	total++;
    	}
        
        
        
      } 
      myReader.close();
      System.out.println(total);
      
      //System.exit(0); //Circuit-breaker stop when testing new files.
      
      String [] words = new String[WordList.size()];
      words = WordList.toArray(words);
      

      String [] words2 = {"chevy", "foist", "gault", "brawl",
    		  			  "roque", "junta", "amnia", "radii",
    		  			  "alula", "optic", "timer", "ozone",
    		  			  "feign", "rhino", "ogive", "weber",
    		  			  "typos", "desks", "raxed", "needs",
    		  			  
    		  			  "craft", "fjord", "gator", "brown",
    		  			  "holey", "ouphe", "amiga", "razee",
    		  			  "equip", "intis", "unmix", "adobe",
    		  			  "vulgo", "stink", "lieve", "wined",
    		  			  "yeans", "tacos", "tared", "liers",
    		  			  
      					  "$hevy", "fo$st", "ti$er",
      					  "$raft", "$ntis", "un$ix"};
      
     doubleSquare(words);
      
      
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
		
		
		
	}
	
	
	
	
	
	
}
