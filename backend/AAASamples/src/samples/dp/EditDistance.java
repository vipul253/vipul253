package samples.dp;

public class EditDistance {

	// only dp[][], no recursion
	public static int editDP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];

				} else {
					int ins = dp[i][j - 1]; // insert
					int del = dp[i - 1][j]; // delete
					int rep = dp[i - 1][j - 1]; // replace

					dp[i][j] = 1 + Math.min(ins, Math.min(del, rep));
				}
			}
		}
		return dp[m][n];

	}

	// recursion and memoization
	public static int edit(String s1, String s2) {
		int i = s1.length();
		int j = s2.length();
		int[][] dp = new int[i + 1][j + 1];
		return editUtil(s1, s2, i - 1, j - 1, dp);
	}

	private static int editUtil(String a, String b, int i, int j, int[][] dp) {
		if (i < 0)
			return j + 1;

		if (j < 0)
			return i + 1;

		if (dp[i][j] != 0)
			return dp[i][j];

		if (a.charAt(i) == b.charAt(j))
			return dp[i][j] = editUtil(a, b, i - 1, j - 1, dp);

		return dp[i][j] = 1 + Math.min(editUtil(a, b, i, j - 1, dp), // insert
				Math.min(editUtil(a, b, i - 1, j, dp), // delete
						editUtil(a, b, i - 1, j - 1, dp))); // replace
	}

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		String s1 = "horse"; // in.nextLine();
		String s2 = "ros"; // in.nextLine();

		System.out.println(edit(s1, s2));
		System.out.println(editDP(s1, s2));
		// in.close();
	}
}
