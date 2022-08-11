package MicroThings;

public class ThreeEx {

	public static void main(String[] args) {
		
	
	int number;
	System.out.println(" ");
	int old=0;
	
	for (int start=1; start <= 10; start++) {
	int count=0;
	number = start;
	while (number > 1) {
		
		if(number %2 == 0) number = number/2;
		else if(number %2 == 1) number = number*3+1;
		count++;
		//System.out.println(count+" "+number);
	
	}
	//System.out.print(count+",");
	System.out.print(count-old+",");
	old = count;
	if(start %10 == 0) System.out.println();
	}
	}

	// 5,-11,8,0,5
	
}
