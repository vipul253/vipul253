package samples.dp;

public class FrogJump {
	// similar to fibo/climbingStairs n-1 or n-2 recursion / DP[]
	// without dp[] tabulation, only prev variable
	public static int frogJumpDPOptimised(int n, int[] heights) {

		int prev1 = 0;
		int prev2 = 0;
		for (int i = 1; i <= n; i++) {
			int v1 = prev1 + Math.abs(heights[i] - heights[i - 1]);

			int v2 = Integer.MAX_VALUE;
			if (i > 1)
				v2 = prev2 + Math.abs(heights[i] - heights[i - 2]);

			prev1 = prev2;
			prev2 = Math.min(v1, v2);
		}

		return prev2;
	}

	// with dp[] tabulation
	public static int frogJumpDP(int n, int[] heights) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			int v1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
			int v2 = Integer.MAX_VALUE;
			if (i > 1)
				v2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
			dp[i] = Math.min(v1, v2);
		}

		return dp[n];
	}

	// recursive
	public static int frogJumpRec(int n, int[] heights) {
		if (n == 0)
			return 0;

		int leftCall = frogJumpRec(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
		int rightCall = Integer.MAX_VALUE;
		if (n > 1)
			rightCall = frogJumpRec(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
		return Math.min(leftCall, rightCall);
	}

	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 10 };
		int n = 4;

		System.out.println(frogJumpRec(n - 1, a));
		System.out.println(frogJumpDP(n - 1, a));
		System.out.println(frogJumpDPOptimised(n - 1, a));

	}

}
