package samples.dp;

public class LongestCommonSubsequence {

	// recursive n*2^n
	public static int lcsRecursive(String a, String b) {
		int m = a.length();
		int n = b.length();
		return lcsRecUtil(m, n, a, b);
	}

	private static int lcsRecUtil(int m, int n, String a, String b) {
		if (m == 0 || n == 0)
			return 0;

		if (a.charAt(m - 1) == b.charAt(n - 1))
			return 1 + lcsRecUtil(m - 1, n - 1, a, b);

		return Math.max(lcsRecUtil(m - 1, n, a, b), lcsRecUtil(m, n - 1, a, b));
	}

	// lcs recursive with DP[] for memoization m*n
	public static int lcsRecMemo(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		return lcsRecUtilMemo(m, n, a, b, dp);
	}

	private static int lcsRecUtilMemo(int m, int n, String a, String b, int[][] dp) {
		if (n == 0 || m == 0)
			return 0;
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return dp[m][n] = 1 + lcsRecUtilMemo(m - 1, n - 1, a, b, dp);
		} else {
			return dp[m][n] = Math.max(lcsRecUtilMemo(m - 1, n, a, b, dp), lcsRecUtilMemo(m, n - 1, a, b, dp));
		}

	}

	// lcs with DP[] for tabular/bottom-up DP
	public static int lcsDP(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m][n];
	}

	// lcs with DP[][] for tabular/bottom-up DP and printing logic
	public static int lcsPrintDP(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		// print LCS string logic
		int i = m, j = n;
		int len = dp[m][n];
		char[] result = new char[len];
		int index = len - 1;

		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				result[index] = a.charAt(i - 1);
				index--;
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		String res = new String(result);
		System.out.println(res);
		return dp[m][n];
	}

	// lcs with prev[], curr[] for tabular/bottom-up DP
	public static int lcsDPMain(String a, String b) {
		int m = a.length();
		int n = b.length();
		int curr[] = new int[n + 1];
		int prev[] = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					curr[j] = 1 + prev[j - 1];
				else
					curr[j] = Math.max(prev[j], curr[j - 1]);
			}
			// Update prev to curr for next iteration
			System.arraycopy(curr, 0, prev, 0, n + 1);
		}

		return prev[n];
	}

	public static void main(String[] args) {
		/*
		 * To find LongestCommonSubsequence by Recursion / DP memoization / DP
		 * bottom-up(tabular)
		 */
		// Scanner in = new Scanner(System.in);
		// String s1 = "abcde"; // in.nextLine();
		// String s2 = "afcde"; // in.nextLine();
		String s1 = "cdegmabcghkkk"; // in.nextLine();
		String s2 = "cdegbcabcghj"; // in.nextLine();

		// System.out.println(lcsRecursive(s1, s2));
		System.out.println(lcsRecMemo(s1, s2));
		System.out.println(lcsDP(s1, s2));
		System.out.println(lcsPrintDP(s1, s2));
		System.out.println(lcsDPMain(s1, s2));
		// in.close();
	}
}
