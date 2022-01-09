package CodeGame;
	import java.util.*;
	import java.io.*;
	import java.math.*;
	
public class Midpoint {
	
	


	/**
	 * Auto-generated code below aims at helping you parse
	 * the standard input according to the problem statement.
	 **/

	    public static void main(String args[]) {
	        //Scanner in = new Scanner(System.in);
	        int x1 = 0;//in.nextInt();
	        int y1 = 0;//in.nextInt();
	        int x2 = 10;//in.nextInt();
	        int y2 = 10;//in.nextInt();

	        // Write an answer using System.out.println()
	        // To debug: System.err.println("Debug messages...");
	        float fx1 = (float) x1;
	        float fx2 = (float) x2;
	        float fy1 = (float) y1;
	        float fy2 = (float) y2;
	        float two = (float) 2.0;

	        float fmx = (fx1+fx2)/two;
	        float fmy = (fy1+fy2)/two;

	        String ansx = "";
	        if (fx1+fx2 % 2 == 0) {
	        	System.out.println("in here");
	           ansx = String.valueOf((int) fmx); }
	        else {
	            ansx = String.valueOf(fmx); }
	    

	        String ansy = "";
	        if (fy1+fy2 % 2 == 0) {
	           ansy = String.valueOf((int) fmy); }
	        else {
	            ansy = String.valueOf(fmy); }


	        System.out.println(ansx+" "+ansy);
	    }
}
