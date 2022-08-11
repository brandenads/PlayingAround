package MyStuff;

public class PrimeNum {
	
	public static void main(String[] args) {
	
		int max = 2000;
		int counter=1;
		
		boolean[] status = new boolean[max+1];
		int [] list = new int[max];
		
		status[1]=false;
		status[2]=true;
		
		for(double i=3.0; i<= max; i++) {
			for(double j=2.0; j<i; j++) {
				status[(int)i] = true;
				if(i % j == 0.0) {
					status[(int)i] = false;
					break;
				}
			}
						
			if (status[(int)i]==true) { 
				System.out.println(i+" --> "+status[(int)i]);
				list[counter]=(int)i;
				counter++;
			}
		}
		
		System.out.println("done");
		int old=2;
		for(int current=1; current<max; current++) {
			for(int k=1; k<=counter; k++) {
				if (list[k] - old == current) {
					System.out.println("Gap size: "+current+" prime number:"+old);
					break;
				}
				//System.out.println(list[k]+" listk - old:"+(list[k]-old)+" current:"+current);
				old = list[k];
				
			}
		}
		
		
	}
}
