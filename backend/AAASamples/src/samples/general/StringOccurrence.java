package samples.general;

public class StringOccurrence {

	/*
	 * Given two strings needle and haystack, return the index of the first
	 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 */

	// double loop to check if str b is found in str a,
	// this O(n*m) but mostly runs well on avg O(n).
	public static int strStr(String haystack, String needle) {
		int haylen = haystack.length();
		int needlelen = needle.length();

		if (haylen < needlelen) {
			return -1;
		}

		for (int i = 0; i <= haylen - needlelen; i++) {
			int j = 0;
			while (j < needlelen && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}
			if (j == needlelen) {
				return i;
			}
		}
		return -1;
	}

	private static int[] computeLPSArray(String pattern) {
		int patternLength = pattern.length();
		int[] LPS = new int[patternLength];
		int prevLPS = 0;
		int index = 1;
		// 1st char LPS always 0 as there are no char previously to compare
		LPS[0] = 0;
		while (index < patternLength) {
			if (pattern.charAt(index) == pattern.charAt(prevLPS)) {
				LPS[index] = LPS[prevLPS] + 1;
				prevLPS++;
				index++;
			} else {// this should run only if does not match therefore nested
				if (prevLPS != 0) {
					prevLPS = LPS[prevLPS - 1];
				} else {
					LPS[index] = 0;
					index++;
				}
			}
		}
		// System.out.println(Arrays.toString(LPS));
		return LPS;
	}

	// KMP to check if str b is found in str a
	// this is O(n+m) which uses a LSP array of needle length
	public static int strKMP(String haystack, String needle) {

		int haylen = haystack.length();
		int patternlen = needle.length();

		if (haylen < patternlen) {
			return -1;
		}
		if (needle == "")
			return 0;

		int[] LPS = computeLPSArray(needle);

		int needleIdx = 0; // pointer for needle re-use to loop through needle length / LPS length
		int haystackIdx = 0; // pointer for hayStack array/string length

		// loop till end of string to search in
		while (haystackIdx < haylen) {
			// if match
			if (haystack.charAt(haystackIdx) == needle.charAt(needleIdx)) {
				haystackIdx++;
				needleIdx++;
			} else {
				if (needleIdx == 0)
					haystackIdx++;
				else
					needleIdx = LPS[needleIdx - 1];
			}
			if (needleIdx == patternlen) {
				return haystackIdx - patternlen;
			}
		}
		return -1;

	}

	// inbuild GG hack
	public int strStr1(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		String a = "aabaaabaaac";
		String b = "aabaaac";
		System.out.println(strStr(a, b));
		System.out.println(strKMP(a, b));
	}
}
