package samples.general;

public class GCDOfStrings {

	/*
	 * For two strings s and t, we say "t divides s" if and only if s = t + t + t +
	 * ... + t + t (i.e., t is concatenated with itself one or more times).
	 * 
	 * Given two strings str1 and str2, return the largest string x such that x
	 * divides both str1 and str2.
	 * 
	 * Example 1:
	 * 
	 * Input: str1 = "ABCABC", str2 = "ABC"
	 * 
	 * Output: "ABC"
	 */
	// general approach
	public static boolean isDivisor(String str1, String str2, int len1, int len2, int subLen) {
		if (len1 % subLen != 0 || len2 % subLen != 0)
			return false;
		int multiply1 = len1 / subLen;
		int multiply2 = len2 / subLen;
		return (str1.substring(0, subLen).repeat(multiply1).equalsIgnoreCase(str1))
				&& (str1.substring(0, subLen).repeat(multiply2).equalsIgnoreCase(str2));

	}

	public static String gcdOfStrings(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		String bigger = len1 > len2 ? str1 : str2;
		String smaller = len2 > len1 ? str1 : str2;
		if (bigger.indexOf(smaller) != -1) {
			for (int i = smaller.length() - 1; i >= 0; i--) {
				if (isDivisor(str1, str2, len1, len2, i + 1))
					return str1.substring(0, i + 1);
			}
		}
		return "";
	}

	// leetcode math approach
	public String gcdOfStringsOP(String str1, String str2) {
		// Step 1: Check if strings have a common divisor
		if (!(str1 + str2).equals(str2 + str1))
			return "";
		// Step 2: Find the GCD of the two lengths
		int gcdLength = gcd(str1.length(), str2.length());
		// Step 3: Return the prefix of that length
		return str1.substring(0, gcdLength);
	}

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) {
		String s1 = "ABCABC";
		String s2 = "ABC";
		System.out.println(gcdOfStrings(s1, s2));
	}
}
