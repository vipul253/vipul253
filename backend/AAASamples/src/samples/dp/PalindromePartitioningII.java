package samples.dp;

public class PalindromePartitioningII {

	// for partitioning types use isPalin which take start and end
	private static boolean isPalindrome(int i, int j, String str) {
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--))
				return false;
		}
		return true;
	}

	// recursive solution will give TLE
	private static int backtrack(int startIdx, int n, String str) {
		// Base case
		if (startIdx >= n)
			return 0;

		int minPart = Integer.MAX_VALUE;
		// Explore each partition from startIndex
		for (int j = startIdx; j < n; j++) {
			if (isPalindrome(startIdx, j, str)) {
				int cost = 1 + backtrack(j + 1, n, str);
				minPart = Math.min(minPart, cost);
			}
		}
		return minPart;
	}

	// recursive solution with dp[] to memoization
	// returns +1 as a|b|c| so do minus 1 to last partition
	private static int backtrackRecDP(int startIdx, int strLen, String str, int[] dp) {
		// Base case
		if (startIdx >= strLen) {
			return 0;
		}
		// Overlapped subproblem
		if (dp[startIdx] != 0) {
			return dp[startIdx];
		}
		int minPart = Integer.MAX_VALUE;
		// Explore each partition from startIndex
		for (int j = startIdx; j < strLen; j++) {
			if (isPalindrome(startIdx, j, str)) {
				int cost = 1 + backtrackRecDP(j + 1, strLen, str, dp);
				minPart = Math.min(minPart, cost);
			}
		}
		return dp[startIdx] = minPart;
	}

	// returns +1 as a|b|c| so do minus 1 to dp[0]
	private static int backtrackDP(String str, int[] dp) {
		int n = str.length();
		for (int i = n - 1; i >= 0; i--) {
			int minPart = Integer.MAX_VALUE;
			// Explore each partition from startIndex
			for (int j = i; j < n; j++) {
				if (isPalindrome(i, j, str)) {
					minPart = Math.min(minPart, 1 + dp[j + 1]);
				}
			}
			dp[i] = minPart;
		}
		return dp[0] - 1;
	}

	// using D[][] matrix
	private static int matrixDP(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];

		for (int gap = 0; gap < n; gap++) {
			for (int row = 0, col = gap; row < n - gap; row++, col++) {
				if (isPalindrome(row, col, str)) {
					dp[row][col] = 0;
				} else {
					dp[row][col] = Integer.MAX_VALUE;
					for (int k = row; k < col; k++) {
						dp[row][col] = Math.min(dp[row][col], 1 + dp[row][k] + dp[k + 1][col]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String str = "aabdcaab";
		int n = str.length();
		int[] dp = new int[n + 1];

		// return ans+1 as a|b|c| sp -1
		System.out.println(backtrack(0, n, str) - 1);
		System.out.println(backtrackRecDP(0, n, str, dp) - 1);
		
		System.out.println(backtrackDP(str, dp));
		
		System.out.println(matrixDP(str));
	}

}
