package HotSeatInterview;

public class ChristmasSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String baseLyrics = "On the ${number[dayLoop]} day of christmas, my true love gave to me.";
		
		String[] gifts = new String[6];
		gifts[1] = "A partridge in a pear tree";
		gifts[2] = "two turtledoves";
		gifts[3] = "three french hens";
		gifts[4] = "four calling birds";
		gifts[5] = "five golden rings";
		
		String[] number = new String[6];
		number[1] = "first";
		number[2] = "second";
		number[3] = "third";
		number[4] = "fourth";
		number[5] = "fifth";
;		
		for (int dayLoop=1; dayLoop <=5; dayLoop++) {
			
			System.out.println("On the "+number[dayLoop]+" day of christmas, my true love gave to me.");
			
			for (int giftLoop = dayLoop; giftLoop >=1; giftLoop--) {
				
				if (dayLoop >1 && giftLoop == 1)
					System.out.print("and ");
				
				System.out.println(gifts[giftLoop]);
				
			}
			System.out.println("");
		}
	

} }
