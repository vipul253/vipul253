package samples.general;

public class SqrtWithoutMathSqrt {

	public static double sqrtBinarySearch(double n) {
	    if (n < 0) return Double.NaN;

	    double low = 0, high = n < 1 ? 1 : n; // Handle numbers < 1
	    double epsilon = 1e-10;

	    while (high - low > epsilon) {
	        double mid = (low + high) / 2.0;
	        if (mid * mid < n) {
	            low = mid;
	        } else {
	            high = mid;
	        }
	    }
	    return Math.ceil(low);
	}
	
	public static void main(String[] args) {
		System.out.println(sqrtBinarySearch(49));
	}
}
