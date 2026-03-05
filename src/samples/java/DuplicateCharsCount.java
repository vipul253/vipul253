package samples.java;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharsCount {
	public static void main(String[] args) {
		String input = "input sample";
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Iterate through each character in the input string
		for (char c : input.toCharArray()) {
			// Increment the count for the current character in the map
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		// Print the counts of duplicate characters
		System.out.println("Duplicate character counts:");
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
	}
}
