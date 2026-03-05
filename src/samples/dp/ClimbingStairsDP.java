package samples.dp;

public class ClimbingStairsDP {
	// You are climbing a staircase. It takes n steps to reach the top.
	// Each time you can either climb 1 or 2 steps. In how many distinct ways can
	// you climb to the top?
	// similar to fibo n-1 or n-2 recursion / DP[]

	// without recursion, no dp[] only prev variables
	public static int climbStairsOptimised(int n) {
		if (n <= 1)
			return 1;
		int prev1 = 1;
		int prev2 = 1;
		for(int i=2;i<=n;i++) {
			int curr = prev1 + prev2;
			prev1 = prev2;
			prev2 = curr;
		}
		return prev2;
	}

	// without recursion only DP[] array
	public static int climbstairsDP(int n) {
		if (n <= 1)
			return 1;
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1] + dp[n - 2];
	}

	// recursion with memoization dp[]
	public static int climbRecMemo(int n) {
		int[] dp = new int[n + 1];
		return climbMemoUtil(n, dp);
	}

	private static int climbMemoUtil(int n, int[] dp) {
		if (n == 0)
			return dp[n] = 1;
		if (n == 1)
			return dp[n] = 1;
		if (dp[n] != 0)
			return dp[n];

		dp[n - 1] = climbMemoUtil(n - 1, dp);
		dp[n - 2] = climbMemoUtil(n - 2, dp);
		return dp[n - 1] + dp[n - 2];
	}

	// recursion call, cannot handle large n value greater than 25
	public static int climbRec(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		int leftCall = climbRec(n - 1);
		int rightCall = climbRec(n - 2);
		return leftCall + rightCall;
	}

	public static void main(String[] args) {
		int n = 21;// 17711

		// System.out.println(climbRec(n));
		System.out.println(climbRecMemo(n));
		System.out.println(climbstairsDP(n));
		System.out.println(climbStairsOptimised(n));

	}
}
