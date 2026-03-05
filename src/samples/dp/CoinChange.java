package samples.dp;

public class CoinChange {

	/*
	 * You are given an integer array coins representing coins of different
	 * denominations and an integer amount representing a total amount of money.
	 * 
	 * Return the fewest number of coins that you need to make up that amount. If
	 * that amount of money cannot be made up by any combination of the coins,
	 * return -1.
	 * 
	 * You may assume that you have an infinite number of each kind of coin.
	 */
	public static int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		// make DP[] to store minimum coin needed for 0 to target amount
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]); // i - coin is curr index - coin
				}
			}
		}
		if (dp[amount] == Integer.MAX_VALUE)
			return -1;

		return dp[amount];
	}

	// recursion based
	public static int coinChangeRec(int[] a, int n) {
		if(n==0)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(n-a[i]>=0) {
				int subAnswer = coinChangeRec(a,n-a[i]);
				if(subAnswer!=Integer.MAX_VALUE && subAnswer+1<ans)
					ans = 1 + subAnswer;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 9 };
		int amount = 11;
		System.out.println(coinChangeRec(coins, amount));
		System.out.println(coinChange(coins, amount));

	}
}
