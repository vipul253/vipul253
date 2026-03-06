package samples.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	/*
	 * Given a string s, partition s such that every substring of the partition is a
	 * palindrome. Return all possible palindrome partitioning of s.
	 * 
	 * Example 1:
	 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
	 */
	private static void backtrack(String str, List<String> partitions, List<List<String>> ans) {

		if (str.length() == 0)
			ans.add(new ArrayList<>(partitions));

		// Explore each partition from startIndex
		for (int i = 0; i < str.length(); i++) {
			String part = str.substring(0, i + 1);
			if (isPalindrome(part)) {
				// Pick: Add current candidate
				partitions.add(part);
				// call for next part i+1
				backtrack(str.substring(i + 1), partitions, ans);
				// not Pick case with next in loop Backtrack: Remove last added candidate
				partitions.remove(partitions.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String str = "aab";
		List<List<String>> ans = new ArrayList<>();
		backtrack(str, new ArrayList<String>(), ans);
		System.out.println(ans);
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
}
