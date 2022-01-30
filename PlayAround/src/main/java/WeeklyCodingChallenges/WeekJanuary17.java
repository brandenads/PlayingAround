package WeeklyCodingChallenges;

public class WeekJanuary17 {

	public static int totalPoints(String[] playerWords, String givenWord) {
		
		
		int totalPoints = 0;
		
		//iterate through the player's words
		for (String pw: playerWords) {
			
			int wordPoints = pw.length()-2;
			if (wordPoints == 4) wordPoints = 54;
			String givenWordTemp = givenWord;
			//System.out.println("The player's word is "+pw);
						
			//iterate through the letters in each word
			for (int i=0; i<pw.length(); i++) {
				
				//if the letter is in the given word.
				int charSpot= givenWordTemp.indexOf(""+pw.charAt(i));
				if ( charSpot >= 0) {
					
					//remove it from the given word
					givenWordTemp = givenWordTemp.substring(0,charSpot)+"*"+
									givenWordTemp.substring(charSpot+1);
					
					//System.out.println(givenWordTemp);
					
				} else {
					
					//word is invalid. It gets no points.
					wordPoints = 0;
					break;
				}
				
			}
			
			//Add the word points to the total points.
			totalPoints += wordPoints;
			//System.out.println("The player earned "+wordPoints+" points for the word "+pw);
		}
		
		
		return totalPoints;
	}
	
	public static boolean canSeeStage (int[][] audience) {
		
		for(int row=audience.length-1; row>=1; row--) {
			
			for(int col=audience[0].length-1; col>=0; col--) {
				
				if (audience[row-1][col] >= audience[row][col])
					
					return false;
				
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); //Should be 2
		System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); //should be 108
		System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); //Should be 13
	
		int [][] stage1 = {{1, 2, 3, 2, 1, 1},
		                   {2, 4, 4, 3, 2, 2},
		                   {5, 5, 5, 5, 4, 4},
		                   {6, 6, 7, 6, 5, 5}};
		System.out.println(canSeeStage(stage1));
		
		int[][] stage2 = new int[][]{{1, 2, 3, 2, 1, 1},
		                  {2, 4, 4, 3, 2, 2},
		                  {5, 5, 5, 10, 4, 4},
		                  {6, 6, 7, 6, 5, 5}};
		System.out.println(canSeeStage(stage2));
	
		System.out.println(
		canSeeStage(new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
			}));
		
		System.out.println(
		canSeeStage(new int[][]{
			{0, 0, 0},
			{1, 1, 1},
			{2, 2, 2}
			}));

		System.out.println(
		canSeeStage( new int[][]{
			{2, 0, 0},
			{1, 1, 1},
			{2, 2, 2}
			}));
		
		System.out.println(
		canSeeStage( new int[][]{
			{1, 0, 0},
			{1, 1, 1},
			{2, 2, 2}
			}));
	}
	
	
}
