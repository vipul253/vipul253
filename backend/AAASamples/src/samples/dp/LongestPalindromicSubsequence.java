package samples.dp;

public class LongestPalindromicSubsequence {

	// lcs with prev[], curr[] for tabular/bottom-up DP
	public static int lcsDPMain(String a, String b) {
		int m = a.length();
		int n = b.length();

		// Use smaller string to minimize space, smaller is the inner loop
		if (m < n) {
			String temp = a;
			a = b;
			b = temp;
			m = a.length();
			n = b.length();
		}

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

	// recursive base approach for palindrome subsequence
	public static int lpsDfs(char[] s, int i, int j) {
		if (i == j) {
			return 1;
		}

		if (i > j) {
			return 0;
		}

		if (s[i] == s[j]) {
			return lpsDfs(s, i + 1, j - 1) + 2;
		}
		return Math.max(lpsDfs(s, i + 1, j), lpsDfs(s, i, j - 1));
	}

	public static void main(String[] args) {
		/*
		 * To find LongestCommonSubsequence by DP bottom-up(tabular)
		 */
		// Scanner in = new Scanner(System.in);
		// String s1 = "abcde"; // in.nextLine();
		// String s2 = "afcde"; // in.nextLine();
		String s1 = "aacabdkacaa"; // in.nextLine();
		String s2 = new StringBuilder(s1).reverse().toString(); // in.nextLine();

		System.out.println(lpsDfs(s1.toCharArray(), 0, s1.length() - 1));
		System.out.println(lcsDPMain(s1, s2));
		// in.close();
	}
}
