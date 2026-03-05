package samples.dp;

public class Knapsack {

	/*
	 * Given two arrays, profit[] and weight[], where each element represents the
	 * profit and weight of an item respectively, also given an integer W
	 * representing the maximum capacity of the knapsack (the total weight it can
	 * hold). Put the items into the knapsack such that the sum of profits
	 * associated with them is the maximum possible, without exceeding the capacity
	 * W.
	 * 
	 */

	// recursion based
	public static int knapsackRec(int n, int W, int[] val, int[] wt) {

		if (n == 0) {
			if (W >= wt[0])
				return val[0];
			else
				return 0;
		}

		int notPick = knapsackRec(n - 1, W, val, wt);
		int pick = Integer.MIN_VALUE;
		if (W >= wt[n])
			pick = val[n] + knapsackRec(n - 1, W - wt[n], val, wt);

		return Math.max(notPick, pick);
	}

	// DP[][] memo based
	public static int knapsackMemoDP(int n, int W, int[] val, int[] wt) {
		int[][] dp = new int[n + 1][W + 1];
		for (int j = wt[0]; j <= W; j++) {
			dp[0][j] = val[0];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				int notPick = dp[i - 1][j];
				int pick = Integer.MIN_VALUE;
				if (j >= wt[i])
					pick = val[i] + dp[i - 1][j - wt[i]];

				dp[i][j] = Math.max(notPick, pick);
			}
		}
		return dp[n][W];
	}

	// instead of matrix dp[][] use two separate prev[] and curr[]
	public static int knapsackMempOptimised(int n, int W, int[] val, int[] wt) {
		int[] prev = new int[W + 1];
		int[] curr = new int[W + 1];

		for (int j = wt[0]; j <= W; j++) { 
			// for all wt[0] to W we can steal so set val[0]
			//check conditon in recursion for clarity;
			prev[j] = val[0];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = W; j >= wt[i]; j--) {

				int notPick = prev[j];
				int pick = val[i] + prev[j - wt[i]]; // removed if(j >= wt[i]) moved to for loop

				curr[j] = Math.max(notPick, pick);
			}
			// Update prev to curr for next iteration
			System.arraycopy(curr, 0, prev, 0, W + 1);
		}
		return prev[W];
	}

	// DP[][] optimized to single d[], start from right to left for inner loop
	// because current value depends on values to left and we can overwrite on right
	// side one by one.
	public static int knapsackDP(int n, int W, int[] val, int[] wt) {
		int[] prev = new int[W + 1];

		for (int j = wt[0]; j <= W; j++) {
			prev[j] = val[0];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = W; j >= wt[i]; j--) {

				int notPick = prev[j];
				int pick = val[i] + prev[j - wt[i]]; // removed if(j >= wt[i]) moved to for loop

				prev[j] = Math.max(notPick, pick);
			}
		}
		return prev[W];
	}

	public static void main(String[] args) {

		int[] weight = { 3, 2, 5 };
		int[] profit = { 30, 40, 60 };
		int knapsack = 6;
//		int[] weight = { 4, 5, 1 };
//		int[] profit = { 1, 2, 3 };
//		int knapsack = 4;
		int len = profit.length;

		System.out.println(knapsackRec(len - 1, knapsack, profit, weight));
		System.out.println(knapsackMemoDP(len - 1, knapsack, profit, weight));
		System.out.println(knapsackMempOptimised(len - 1, knapsack, profit, weight));
		System.out.println(knapsackDP(len - 1, knapsack, profit, weight));

	}
}
