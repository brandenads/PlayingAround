package MyStuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DuoSquareMapped {

	static HashMap<String, List<String>> wordMap = new HashMap<String, List<String>>();
	static int squareSize;
	static String [] wordList;
	static int mostUniqueLetters = 0;
	static int squaresSinceUnique=0;
	
	private static void createPrefixMap(String[] words) {
		for(String word: words) {
			for(int i=0; i<=word.length(); i++) {
				String prefix=word.substring(0,i);
				wordMap.putIfAbsent(prefix, new ArrayList<String>());
				List<String> list = wordMap.get(prefix);
				list.add(word);
			}
		}
	}
	
	public static void doubleSquare (String [] words) {
		
		char[][] currentSquare = new char[squareSize][squareSize];
		
		wordList = words;
		
		createPrefixMap(wordList);
		
		for(int topWord=0; topWord < wordList.length; topWord++) {
			
			//Put top word in
			for(int fillTop=0; fillTop<squareSize; fillTop++) {
				currentSquare[0][fillTop] = wordList[topWord].charAt(fillTop);
			}
			
			//Fill subsequent lines
			fillSquareRecurse(1, currentSquare);
			//break;
			
			//printSquare(currentSquare);
		}
		
	}
	
	private static void fillSquareRecurse (int level, char[][] squareSoFar) {
		
		//Traverse word list
		int validity;
		for(int rowWord=0; rowWord<wordList.length; rowWord++) {
			
			//Check if the next word is compatible with the current word in the list.
			//Getting the letters of the net word
			validity=0;
			for(int wordChar=0; wordChar<squareSize; wordChar++) {
				StringBuilder stub = new StringBuilder("");
				
				//Create the prefix stub
				for(int above=0; above<level; above++)
					stub.append(squareSoFar[above][wordChar]);
				stub.append(wordList[rowWord].charAt(wordChar));
				//System.out.println("stub is "+stub);
				
				List<String> prefixWordList = wordMap.getOrDefault(stub.toString(), new ArrayList<String>());
				if (prefixWordList.size() > 0) validity++;
				
			} //end of wordChar for statement
			
			//If the word is valid, add it to the square and continue to the next level
			if(validity==squareSize) {
				for(int inSquare=0; inSquare<squareSize; inSquare++)
					squareSoFar[level][inSquare] = wordList[rowWord].charAt(inSquare);
				//If it is complete, return.
				if(level==squareSize-1) {
					
					squaresSinceUnique++;
					//Calculate number of unique letters
					int uniqueLetters=0;
					int [] asciii = new int[130];
					for(int uniqueRow=0; uniqueRow<squareSize; uniqueRow++)
						for (int uniqueCol=0; uniqueCol<squareSize; uniqueCol++)
							asciii[squareSoFar[uniqueRow][uniqueCol]]++;
					for(int countUnique=0; countUnique<130; countUnique++)
						if(asciii[countUnique]==1)
							uniqueLetters++;
					if (uniqueLetters > mostUniqueLetters) {
						mostUniqueLetters = uniqueLetters;
						squaresSinceUnique = 0;
					}
					
					if (uniqueLetters == mostUniqueLetters) {
						System.out.println("====================  Unique: "+uniqueLetters+" Record: "+mostUniqueLetters+" Gap: "+squaresSinceUnique);
						printSquare(squareSoFar);
					}
					return;
				}
				
				//If it is incomplete, recurse.
				if(level < squareSize-1) {
					int nextlevel = level + 1;

				    //Cleanout next levels, for readable debugging
					for(int cleanlev=nextlevel; cleanlev<squareSize; cleanlev++)
						for(int cleanout=0;cleanout<squareSize; cleanout++)
							squareSoFar[cleanlev][cleanout]=' ';
					
					//System.out.println("in com plete");
				    //printSquare(squareSoFar);
				    
				    if (nextlevel<squareSize) //debug stop
				    	fillSquareRecurse(nextlevel, squareSoFar);
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
		
		//Control settings
		squareSize = 6;
		boolean okToRepeat=false;
	
		
		
		
		int total=0;
	    ArrayList<String> rawWordList = new ArrayList<String>();

    try {
        //int taters=0;
    //File myObj = new File("c:\\javafiles\\web2.txt"); 
    File myObj = new File("c:\\javafiles\\NPLCombinedWordList.txt");
      Scanner myReader = new Scanner(myObj);
     while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        
        int goodChars=0;
        boolean repeatedLetters = false;
        int [] asciiVal = new int[130];

        if(data.length() ==  squareSize) {
        	
	        for(goodChars=0; goodChars<data.length(); goodChars++) {
	        	int ascii = data.charAt(goodChars);
	        	if (ascii > 122 || ascii < 97) 
	        		break;
	        	asciiVal[ascii]++;
	        	if (asciiVal[ascii]>1)
	        		repeatedLetters = true;
	        }
	        
	        if (goodChars == data.length()) {
	    	   	//taters++; if (taters==20) {System.exit(0);}//{System.out.println(""); taters=0;}
	    	   	if (!(repeatedLetters && !okToRepeat)) {
		    	   	System.out.println(data+" "+repeatedLetters);
		    	   	rawWordList.add(data);
		    	   	total++;
	    	   	}
	    	}	    
        
        }

        
        
        
      } 
      myReader.close();
      System.out.println(total);
      
      //System.exit(0); //Circuit-breaker stop when testing new files.
      
      String [] words = new String[rawWordList.size()];
      words = rawWordList.toArray(words);
      

      String [] words2 = {"chevy", "foist", "gault", "brawl",
    		  			  "roque", "junta", "amnia", "radii",
    		  			  "alula", "optic", "timer", "ozone",
    		  			  "feign", "rhino", "ogive", "weber",
    		  			  "typos", "desks", "raxed", "needs",
    		  			  
    		  			  "craft", "fjord", "gator", "brown",
    		  			  "holey", "ouphe", "amiga", "razee",
    		  			  "equip", "intis", "unmix", "adobe",
    		  			  "vulgo", "stink", "lieve", "wined",
    		  			  "yeans", "tacos", "tared", "liers"};
    		  			  
      String [] words3 = {"chevy", "foist", "gault", "brawl",
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
