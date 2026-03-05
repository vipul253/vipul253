package samples.java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class ValidPrime {

	static boolean isPrime(long n) {
		// Corner case
		if (n <= 1)
			return false;
		//check for 2 and 3
		if (n == 2 || n == 3)
			return true;
		//check for divisibility by 2 and 3
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		//then loop from 5 to square root of num with i incremented by 6
		for (int i = 5; i < Math.sqrt(n); i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	// Driver Program
	public static void main(String args[]) {
		System.out.println(isPrime(11));
		System.out.println(isPrime(15));
		System.out.println(isPrime(123456789));
		
		BigDecimal[] s = { //bigDecimalArray
	            new BigDecimal("100.50"),
	            new BigDecimal("250.75"),
	            new BigDecimal("0.01"),
	            new BigDecimal("-150.25"),
	            new BigDecimal("999.99")
	        };
		Arrays.sort(s, 0, s.length, (a, b) -> b.compareTo(a));
		
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = "11";//bufferedReader.readLine();
        //bufferedReader.close();
        BigInteger bint = new BigInteger(n);
        
		//bint.isProbablePrime(Integer certainity) higher the certainity more the calculation times
        if(bint.isProbablePrime(10)){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }


	}
}
