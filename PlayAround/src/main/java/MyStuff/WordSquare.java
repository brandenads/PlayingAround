package MyStuff;

	import java.io.File;  // Import the File class
	import java.io.FileNotFoundException;  // Import this class to handle errors
	import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

//  https://www.youtube.com/watch?v=YTQjsPiMtRk

public class WordSquare {


	//public static ArrayList<String> WordList;
	static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	
	public static List<List<String>> wordSquares (String [] words) {
		List<List<String>> result = new ArrayList<List<String>>();
		createPrefixMap(words);
		for(int i=0; i<words.length; i++) {
			LinkedList<String> list = new LinkedList<String>();
			list.add(words[i]);
			//System.out.println("Before Backtrack: i "+i+" total "+words.length);
			backTrack(1, list, result, words[i].length());
		}
		System.out.println("Ready to return to the main method...");
		return result;
	}
	
	private static void backTrack (int step, LinkedList<String> list, List<List<String>> result, int n) {
		if(list.size() == n) {
			result.add(new ArrayList<String>(list));
			
			//Determine unique letters of the alphabet
			int uniqueThreshold = 10; //Threshold for number of unique letters. No lower than 10 !
			
			String listString = list.toString();
			int [] asciiVals = new int[128];
			int unique=0;
			for(int u=0;u<listString.length();u++) {
				int ascii = listString.charAt(u);
				asciiVals[ascii]++;
				if (asciiVals[ascii]==1) unique++;
			}
			if (unique>=uniqueThreshold) System.out.println(list+" "+unique);
			//End added code for unique alphabet letters
			
			
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(String word: list) {
			sb.append(word.charAt(step));
		}
		String prefix = sb.toString();
		List<String> wordList = map.getOrDefault(prefix, new ArrayList<String>());
		for (String word: wordList) {
			list.add(word);
			
			//if (list.get(0).charAt(0)=='z')
			//System.out.println("in backtrack:"+step+1+" "+list+" "+ n);
			
			backTrack(step+1, list, result, n);
			
			//if (list.get(0).charAt(0)=='z') flag=1;
			//if (flag==1) System.out.println("removing LAST!");
			list.removeLast();
		}
		
	}
	
	private static void createPrefixMap(String[] words) {
		for(String word: words) {
			for(int i=0; i<word.length(); i++) {
				String prefix=word.substring(0,i);
				map.putIfAbsent(prefix, new ArrayList<String>());
				List<String> list = map.get(prefix);
				list.add(word);
			}
		}
	}
		
	
	public static void main( String[] args) {
		
		int WordSquareSize = 4;
		
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
      
      String [] words2 = {"area","lead","wall","lady","ball","lads", "leod","zyyx"};
      String [] words3 = {"area", "lead","ball"};
      wordSquares(words);
      
      
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 

		
		
		
		
		
		
		
		
		
		
		
	}
}
