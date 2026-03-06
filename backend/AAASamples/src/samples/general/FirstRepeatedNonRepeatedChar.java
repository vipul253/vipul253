package samples.general;

import java.util.BitSet;

public class FirstRepeatedNonRepeatedChar {

	// to find the first repeated and Non-repeated character in a String
	public static void main(String[] args) {
		String s = "abcdab"; // first repeated = a, non-repeated = c
		firstRepeatedNonRepeatedChar(s);
	}

	public static void firstRepeatedNonRepeatedChar(String s) {
		if (s.isEmpty()) {
			System.out.println("empty string");
			return;
		}
		BitSet seen = new BitSet(), repeated = new BitSet();
		s.chars().forEachOrdered(c -> (seen.get(c) ? repeated : seen).set(c));
		if (repeated.isEmpty())
			System.out.println("first unique: " + s.charAt(0));
		else {
			s.chars().filter(c -> repeated.get(c)).findFirst()
					.ifPresent(c -> System.out.println("first repeated: " + (char) c));
			s.chars().filter(c -> !repeated.get(c)).findFirst()
					.ifPresent(c -> System.out.println("first unique: " + (char) c));
		}
	}
}
