package MyStuff;

import java.util.Arrays;

public class MultiplicationTable {

	
	
	
	
	public static void main(String[] args) {
		
		long [][] table = new long[10001][10001];
		int [][] table2 = new int [100][100];
		
		for (int i=1; i<=10000; i++) 
			for(int j=1; j<=10000; j++)
				table[i][j]=i*j; 
	}
	
}
