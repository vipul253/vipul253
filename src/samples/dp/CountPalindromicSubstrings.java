package samples.dp;

public class CountPalindromicSubstrings {

	// count palindromic substrings by outward expansion from index,
	// for even and odd palindromes
	public static int countPalindromicSubstrings(String a) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			// count odd length palindromes i.e index can be ignored
			// and take prev & next index to compare
			count += countPalindromes(a, i, i);

			// count even length palindromes i.e index can be ignored
			// and take index & next index to compare
			count += countPalindromes(a, i, i + 1);
		}
		return count;
	}

	private static int countPalindromes(String a, int left, int right) {
		int c = 0;
		while (left >= 0 && right < a.length() && a.charAt(left) == a.charAt(right)) {
			c++;
			left--;
			right++;
		}
		return c;
	}

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		String s1 = "aacabdkacaa"; // in.nextLine();
		System.out.println(countPalindromicSubstrings(s1));
		// in.close();
	}
}
