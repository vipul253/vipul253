package samples.general;

public class LongestSubstringWithoutRepeatingChar {
	// brute force
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] hash = new int[256];
			int currMax = 0;
			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				if (hash[c] == 1)
					break;
				currMax++;
				hash[c] = 1;
			}
			max = Math.max(currMax, max);
		}
		return max;
	}

	// optimized using hash and 2 pointer window
	public static int lengthOfLongestSubstringOP(String s) {
		int max = 0;
		int left = 0, right = 0;
		int[] hash = new int[256];
		for (int i = 0; i < hash.length; i++)
			hash[i] = -1;
		while (right < s.length()) {
			char ch = s.charAt(right);
			if (hash[ch] != -1 && hash[ch] >= left) {
				left = hash[ch] + 1;
			}
			max = Math.max(max, right - left + 1);
			hash[ch] = right;
			right++;
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstringOP(s));
	}
}
