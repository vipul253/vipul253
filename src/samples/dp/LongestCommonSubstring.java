package samples.dp;

public class LongestCommonSubstring {

	// lcs with DP[][] for tabular/bottom-up DP
	public static int lcSubstringDP(String a, String b) {
		int m = a.length();
		int n = b.length();
		int ans = 0;
		int dp[][] = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];

				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}

	// lcs replaced DP[][] with prev[] curr[] for optimized tabulation/bottom-up DP
	public static int LCSubstringDPMain(String a, String b) {
		int m = a.length();
		int n = b.length();

		// Use smaller string to minimize space
		if (m < n) {
			String temp = a;
			a = b;
			b = temp;
			m = a.length();
			n = b.length();
		}

		int ans = 0;
		int prev[] = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= 1; j--) { //doing right to left to remove dependency on curr[j]
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					prev[j] = 1 + prev[j - 1];
					ans = Math.max(ans, prev[j]);
				} else {
					prev[j] = 0;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		// To find LongestCommonSubstring by Recursion / DP memoization or
		// bottom-up(tabulation)

		// Scanner in = new Scanner(System.in);
		// String s1 = "abcde"; // in.nextLine();
		// String s2 = "afcde"; // in.nextLine();
		String s1 = "aacabdkacaa"; // in.nextLine();
		String s2 = "aacakdbacaa"; // in.nextLine();

		System.out.println(lcSubstringDP(s1, s2));
		System.out.println(LCSubstringDPMain(s1, s2));
		// in.close();
	}
}
