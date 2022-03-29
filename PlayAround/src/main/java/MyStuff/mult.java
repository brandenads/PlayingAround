package MyStuff;

import java.util.Arrays;

public class mult {

	
	
	
	
	public static void main(String[] args) {
		
		//The old way
		int max=200;
		int[] table = new int[max*max+1];
		int[] table2 = new int[max*max+1];
		
		for (int c=1; c<=max; c++) {
			
				//The old way
				for(int ee=1; ee<=max*max; ee++) //delete the array
					table[ee]=0;
				for (int i=1; i<=max; i++) //Fill the array
					for(int j=1; j<=max; j++)
						table[i*j]++; 
				
				//The new way
				for(int s=1; s<c; s++)
					table2[s*c]+= 2;
				table2[c*c]++;
				table2[1]=1;
		
		}
		
		for(int d=1; d<=max; d++)
			System.out.println("Old Way: "+table[d]+" new way: "+table2[d]);
		
		
		
		
}
	
}
