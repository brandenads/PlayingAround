package MyStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class AlphaSort {

	public static void main(String[] args) throws IOException {
		
		String myPath = "C:\\Users\\brand\\git\\PlayingAround\\PlayAround\\src\\main\\resources\\";
		
		int fileSize=45400;
		
		int randomSeed = 400;
		
		FileReader word_reader = new FileReader(myPath+"words.txt");
		BufferedReader word_buffer = new BufferedReader(word_reader);
		
		
		File vowelA_File = new File(myPath+"vowelA.txt");
		vowelA_File.createNewFile();
		FileWriter vowelA_Writer = new FileWriter(vowelA_File);
		
		File vowelE_File = new File(myPath+"vowelE.txt");
		vowelE_File.createNewFile();
		FileWriter vowelE_Writer = new FileWriter(vowelE_File);
		
		File vowelI_File = new File(myPath+"vowelI.txt");
		vowelI_File.createNewFile();
		FileWriter vowelI_Writer = new FileWriter(vowelI_File);
		
		File vowelO_File = new File(myPath+"vowelO.txt");
		vowelO_File.createNewFile();
		FileWriter vowelO_Writer = new FileWriter(vowelO_File);
		
		File vowelU_File = new File(myPath+"vowelU.txt");
		vowelU_File.createNewFile();
		FileWriter vowelU_Writer = new FileWriter(vowelU_File);
		
		String nextLine = "";
		
		Random rnd = new Random();
		
		while ((nextLine = word_buffer.readLine()) != null) {
			

			
			if(rnd.nextInt(randomSeed) == 0) {
				System.out.print("The word "+nextLine+" contains the vowels ");
				
				System.out.print("[FILE]");
				if( nextLine.contains("a")) {
					System.out.print(",a ");
					vowelA_Writer.write(nextLine+"\n");
				}
				if( nextLine.contains("e")) {
					System.out.print(",e ");
					vowelE_Writer.write(nextLine+"\n");
				}
				if( nextLine.contains("i")) {
					System.out.print(",i ");
					vowelI_Writer.write(nextLine+"\n");
				}
				if( nextLine.contains("o")) {
					System.out.print(",o ");
					vowelO_Writer.write(nextLine+"\n");
				}
				if( nextLine.contains("u")) {
					System.out.print(",u ");
					vowelU_Writer.write(nextLine+"\n");
				}
				
				System.out.print("\n");

			} //random if

			
		} //while
		
		vowelA_Writer.flush();
		vowelA_Writer.close();
		
		vowelE_Writer.flush();
		vowelE_Writer.close();
		
		vowelI_Writer.flush();
		vowelI_Writer.close();
		
		vowelO_Writer.flush();
		vowelO_Writer.close();
		
		vowelU_Writer.flush();
		vowelU_Writer.close();
		
	
		
		
	} //main
} //class
