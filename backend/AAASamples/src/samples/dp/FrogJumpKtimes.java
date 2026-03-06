package samples.dp;

public class FrogJumpKtimes {

	// with dp[] tabulation
	public static int frogJumpDP(int n, int k, int[] heights) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			int minSteps = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
					minSteps = Math.min(minSteps, jump);
				} else {
					break;
				}
			}
			dp[i] = minSteps;
		}
		return dp[n];
	}

	// recursive
	public static int frogJumpRec(int n, int k, int[] heights) {
		if (n == 0)
			return 0;

		int minSteps = Integer.MAX_VALUE;
		for (int j = 1; j <= k; j++) {
			if (n - j >= 0) {
				int jump = frogJumpRec(n - j, k, heights) + Math.abs(heights[n] - heights[n - j]);
				minSteps = Math.min(minSteps, jump);
			}
		}

		return minSteps;
	}

	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 10 };
		int n = 4;
		int k = 2;
		System.out.println(frogJumpRec(n - 1, k, a));
		System.out.println(frogJumpDP(n - 1, k, a));

	}
}
