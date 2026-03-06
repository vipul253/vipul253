package samples.dp;

public class LongestPalindromicSubstring {
	// cannot use LCsubstring as base because reverse of some strings like
	// "aacabdkacaa" are not palindrome even in reverse like "aaca" & "acaa",
	// this works for subSequence but not substring as substring is continuous

	// count palindromic substrings by outward expansion from index, for even and
	// odd palindromes
	public static String LPSubstrings(String s) {
		if (s == null || s.length() < 1)
			return "";
		int end = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = countPalindromeLength(s, i, i); // odd call
			int len2 = countPalindromeLength(s, i, i + 1); // even call
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2; // left point i - len/2 but index from 0 so len-1
				end = i + (len) / 2; // right point i + len/2
			}
		}
		return s.substring(start, end + 1);
	}

	private static int countPalindromeLength(String a, int left, int right) {
		while (left >= 0 && right < a.length() && a.charAt(left) == a.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1; // length of palindrome, -1 for 0 array index
	}

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		String s1 = "cbbd"; // in.nextLine();
		// String s2 = "aacakdbacaa";
		// String s2 = new StringBuilder(s1).reverse().toString(); // in.nextLine();
		System.out.println(LPSubstrings(s1));
		System.out.println(longestPalindrome("babad")); // Output: "bab" or "aba"
		System.out.println(longestPalindrome("aaca")); // Output: "bb"
		// in.close();
	}

	// DP[][] approach
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";

		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int start = 0, maxLen = 1;

		// Every single char is a palindrome
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}

		// Check for substrings of length 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				start = i;
				maxLen = 2;
			}
		}

		// Check for lengths > 2
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i <= n - k; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {// 1 3 2 2
					dp[i][j] = true;
					start = i;
					maxLen = k;
				}
			}
		}
		return s.substring(start, start + maxLen); // this is start index and til endIndex -1
	}

}
