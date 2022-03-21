package MyStuff;

public class nFactors {
	
	public static void main(String[] args) {
		
		int maxi=20;
		double bigNumber = 1000000;
		int numFactors = 0;
		boolean isFactor = false;
		
		double[] nums = new double[maxi];
		
		for(double n=1; n<=maxi; n++) {
			
			
			for(double u=1; u<=bigNumber; u++) {
				
				numFactors = 0;
				String factorList = "";
				
				for(double d=1; d<=u; d++) {
					
					String numstr = Double.toString(u/d);
					String lastwo = numstr.substring(numstr.length()-2);
	
					isFactor = false;
					if (lastwo.equals(".0")) {
						numFactors++;
						factorList = factorList.concat(Integer.toString((int) d)+" ");
						//System.out.println("FL is "+factorList+" double is "+Double.toString(d));
						isFactor = true;
					}
					
					//System.out.println("Numerator: "+u+" denominator "+d+" Number string "+numstr+" is a Factor: "+ isFactor+" lastwo: "+lastwo);
					
				} //denominator loop 
				
				if (numFactors == n) {
					System.out.println(" The number "+(int)u+" has "+numFactors+" factors, they are "+factorList);
					break;
				}
				
			} //numerator loop
			
			
		}

	}
	

}
