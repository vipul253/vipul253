package samples.general;

public class Palindrome {

	// for partitioning types use isPalin which take start and end
	public static boolean isPalindrome(int i, int j, String str) {
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--))
				return false;
		}
		return true;
	}

	public static boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		String s1 = "aca"; // in.nextLine();
		System.out.println(isPalindrome(s1));
		// in.close();
	}
}
