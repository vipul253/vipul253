package samples.general;

public class MergeStringsAlternately {

	/*
	 * You are given two strings word1 and word2. Merge the strings by adding
	 * letters in alternating order, starting with word1. If a string is longer than
	 * the other, append the additional letters onto the end of the merged string.
	 * 
	 * Return the merged string.
	 */
	public static String mergeAlternately(String word1, String word2) {
		int wLen1 = word1.length();
		int wLen2 = word2.length();
		char[] ans = new char[wLen1 + wLen2];
		int w1 = 0;
		int w2 = 0;
		int smallerWord = wLen1 < wLen2 ? wLen1 : wLen2;
		for (int i = 0; i < smallerWord; i++) {
			ans[i * 2] = word1.charAt(w1++);
			ans[i * 2 + 1] = word2.charAt(w2++);
		}
		smallerWord = smallerWord * 2;
		while (w1 < wLen1)
			ans[smallerWord++] = word1.charAt(w1++);
		while (w2 < wLen2)
			ans[smallerWord++] = word2.charAt(w2++);
		return new String(ans);
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "pqrs";
		System.out.println(mergeAlternately(s1, s2));
	}
}
