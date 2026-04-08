package samples.interview;

import java.util.HashMap;
import java.util.Map;

public class MaxUniqueCharInWindowK {

	/*
	 * Find maximum unique characters in a window of k size in a string
	 */
	public static int findMaxUnique(String s, int k) {
		if (s == null || s.length() < k || k <= 0)
			return 0;

		Map<Character, Integer> freqMap = new HashMap<>();
		int maxUnique = 0;

		// Initialize first window of size k
		for (int i = 0; i < k; i++) {
			freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
		}
		maxUnique = freqMap.size();

		// Slide the window from k to end of string
		for (int i = k; i < s.length(); i++) {
			// Add new character
			char newChar = s.charAt(i);
			freqMap.put(newChar, freqMap.getOrDefault(newChar, 0) + 1);

			// Remove character that left the window
			char oldChar = s.charAt(i - k);
			int count = freqMap.get(oldChar);
			if (count == 1) {
				freqMap.remove(oldChar);
			} else {
				freqMap.put(oldChar, count - 1);
			}
			// Update max unique characters found so far
			maxUnique = Math.max(maxUnique, freqMap.size());
		}

		return maxUnique;
	}

	public static void main(String[] args) {
		String s = "abccdeffg";
		int k = 3;
		System.out.println("Max Unique Characters: " + findMaxUnique(s, k));
		System.out.println("Max Unique Characters: " + findMaxUniqueNoMap(s, k));
		// Example: "cde" has 3 unique characters
	}
	
	// without HashMap
	public static int findMaxUniqueNoMap(String s, int k) {
        if (s == null || k <= 0 || k > s.length()) return 0;

        int[] freq = new int[256]; // Replaces HashMap
        int uniqueCount = 0;
        int maxUnique = 0;

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            if (freq[s.charAt(i)] == 0) uniqueCount++;
            freq[s.charAt(i)]++;
        }
        maxUnique = uniqueCount;

        // Slide the window through the rest of the string
        for (int i = k; i < s.length(); i++) {
            // Remove the character that is sliding out (left side)
            char leftChar = s.charAt(i - k);
            freq[leftChar]--;
            if (freq[leftChar] == 0) uniqueCount--;

            // Add the new character (right side)
            char rightChar = s.charAt(i);
            if (freq[rightChar] == 0) uniqueCount++;
            freq[rightChar]++;

            // Update maxUnique found so far
            maxUnique = Math.max(maxUnique, uniqueCount);
        }

        return maxUnique;
    }
}
