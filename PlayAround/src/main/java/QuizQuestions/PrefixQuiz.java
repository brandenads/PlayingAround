package QuizQuestions;
import java.util.*; 
	import java.lang.*;
	import java.io.*;
	import java.lang.Math;



public class PrefixQuiz {

	    public static int answers(int N, int[] A) {
	        
	        //this is default OUTPUT. You can change it.
	        
	        //write your Logic here:
	        int WindHeight = 0;
	        int[] Left = new int[N];
	        int[] Right = new int[N];
	        int LeftTotal=0;
	        int RightTotal=0;
	        
	        //From the Left
	        for(int i=0; i<N; i++)
	        	if (A[i] > WindHeight) { //if house is higher than wind
	                WindHeight = A[i];
	                Left[i] = 1;
	            }
	            else {
	                Left[i]=2; //if house is shorter than wind
	                LeftTotal++;
	            }
	        
	        //From the Right
	        WindHeight=0;
	        for(int i=N-1; i>=0; i--) {
	       
	            if (A[i] > WindHeight) { //if house is higher than wind
	                WindHeight = A[i];
	                Right[i] = 1;
	            }
	            else  {
	            	//if house is shorter than wind
	                Right[i]=2;
	                RightTotal++;
	            }
	        }
	        
	        //Both
	        int total=0;
	        for(int i=0;i<N;i++)
	        	if (Left[i]==2 && Right[i]==2) //see how many houses are shorter than both winds
	                total++;

	        System.out.print(LeftTotal+" "+RightTotal+" ");
	        return total;
	        
	        
	    }
	    
	    public static void main(String[] args) {
	    	int[] Example1 = {2, 3, 3, 1, 5}; //5
	    	int[] Example2 = {474, 362, 381, 54, 186, 306, 141, 2, 231, 428, 30, 244, 359, //176
	    					  474, 487, 187, 364, 269, 368, 443, 41, 214, 110, 379, 27, 473, 309,
	    					  162, 434, 207, 97, 94, 68, 255, 474, 189, 404, 96, 359, 272, 468, 228,
	    					  397, 96, 261, 428, 179, 158, 475, 26, 129, 335, 375, 171, 190, 189, 75, 3,
	    					  338, 169, 238, 77, 376, 29, 220, 116, 438, 364, 409, 266, 446, 115, 15, 478,
	    					  205, 371, 8, 209, 455, 188, 214, 204, 278, 244, 208, 165, 274, 224, 192, 383,
	    					  356, 390, 97, 235, 301, 428, 270, 189, 394, 304, 487, 218, 90, 321, 310, 474};
	    	
	    	int[] A = Example2;
	    	int N = 106;

	        System.out.print(answers(N, A));
	        
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

