package samples.dp;

public class Fibonacci {

	// 0 1 1 2 3 5 8 13 21 34 using recursion and DP[]

	// DP without dp[], no tabulation, only prev variable T = O(n) & S = O(1)
	public static long fibDPOptimised(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		long prev0 = 0;
		long prev1 = 1;

		for (int i = 2; i <= n; i++) {
			long curr = prev1 + prev0;
			prev0 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	// only with DP[] Tabulation(bottom-up) convert recursion to iteration loop
	public static long fibDP(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		//System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	// recursive with DP[] memoization
	public static long fibMemo(int n) {
		long[] dp = new long[n + 1];
		return fibMemoUtil(n, dp);
	}

	private static long fibMemoUtil(int n, long[] dp) {
		if (n == 0)
			return dp[0] = 0;
		if (n == 1)
			return dp[1] = 1;
		if (n > 1 && dp[n] == 0)
			return dp[n] = fibMemoUtil(n - 1, dp) + fibMemoUtil(n - 2, dp);

		return dp[n];
	}

	// recursive
	public static long fibRec(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibRec(n - 1) + fibRec(n - 2);

	}

	public static void main(String[] args) {
		int n = 20;
		// System.out.println(fibRec(n));
		System.out.println(fibMemo(n));
		System.out.println(fibDP(n));
		System.out.println(fibDPOptimised(n));

	}
}
