package samples.general;

public class SegmentDivisionEqualUnequal {
	/*
	 * Divide a segment of length N into 4 integer-length parts such that the first
	 * 2 parts are equal and the last 2 parts are equal but but first 2 and last 2
	 * are not equal.
	 * 
	 * we can use the following approach in Java. This problem is equivalent to
	 * finding integer solutions for (a, a, b, b) where:
	 * 
	 * 2a + 2b = N, a ≠ b , a > 0, b > 0, Key Insight From 2a + 2b = N, we get a + b
	 * = N/2. So, N must be even; otherwise, no valid solution exists.
	 * 
	 * Let sum = N / 2. Then b = sum - a. We need a ≠ b → a ≠ sum - a → 2a ≠ sum → a
	 * ≠ sum / 2.
	 * 
	 * E.g. given 6 then we can only make 1,1,2,2
	 */

	public static int countWays(int N) {
		if (N % 2 != 0)
			return 0; // N must be even; otherwise, no valid solution exists.
		int sum = N / 2;
		int count = 0;
		// a ranges from 1 to sum-1 to ensure b > 0
		for (int a = 1; a < sum; a++) {
			int b = sum - a;
			if (a != b) { // ensures unequal pair
				count++;
			}
		}
		return count / 2;// we need count of pairs not the total numbers
	}

	public static void main(String[] args) {
		int N = 20;
		System.out.println(countWays(N));
	}
}
