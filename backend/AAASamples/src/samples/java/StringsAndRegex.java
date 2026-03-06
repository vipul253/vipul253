package samples.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//longest consecutive sequence in an array of integers
public class StringsAndRegex {

	/*
	 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split
	 * the string into tokens. We define a token to be one or more consecutive
	 * English alphabetic letters. Then, print the number of tokens, followed by
	 * each token on a new line. He is a very very good boy, isn't he? 10 He is a
	 * very very good boy isn t he
	 */
	public static void onlyFilterAlphabetsAsTokens(String s) {

		s = "He is a very very good boy, isn't he?";
		Pattern p = Pattern.compile("[A-Za-z]+"); // only keeps alphabets
		Matcher m = p.matcher(s);// matches with given string s

		List<String> tokens = new ArrayList<>();
		while (m.find()) {
			tokens.add(m.group());
		}

		System.out.println(tokens.size());
		for (String token : tokens) {
			System.out.println(token);
		}
	}

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		String s = "abchijkdef";// in.nextLine();
		int k = 3; // in.nextInt();
		System.out.println(getSmallestAndLargest(s, k));
		checkDuplicateWordAndReplace("test");
		//in.close();
	}

	// to get lexicographically smallest and largest k length substring from a
	// string
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = s.substring(0, k); // Initialize with the first substring
		String largest = s.substring(0, k); // Initialize with the first substring

		for (int i = 1; i <= s.length() - k; i++) {
			String currentSubstring = s.substring(i, i + k);

			if (currentSubstring.compareTo(smallest) < 0) {
				smallest = currentSubstring;
			}

			if (currentSubstring.compareTo(largest) > 0) {
				largest = currentSubstring;
			}
		}
		return "smallest --> "+ smallest + "\nlargest --> " + largest;
	}

	public static void checkDuplicateWordAndReplace(String s) {
		String regex = "\\b(\\w+)(\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		// Scanner in = new Scanner(System.in);
		int numSentences = 1; // Integer.parseInt(in.nextLine());
		while (numSentences-- > 0) {
			String input = "hello the the world world"; // in.nextLine();

			Matcher m = p.matcher(input);
			// match repeated words like "hello the the world world" and
			// replace to "hello the world"
			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}

			System.out.println(input);
		}
	}
	
	//regex to match <tag>text</tag>
	public static void matchTags(String s) {
		//Scanner in = new Scanner(System.in);
		int testCases = 1; //Integer.parseInt(in.nextLine());
		String regex = "<(.+)>([^<]+)</\\1>";
		Pattern pattern = Pattern.compile(regex);
		while (testCases > 0) {
			String line = "<tag>text</tag>";//in.nextLine();

			// Write your code here
			Matcher matcher = pattern.matcher(line);
			boolean found = false;
			while (matcher.find()) {
				System.out.println(matcher.group(2));
				found = true;
			}
			if (!found)
				System.out.println("None");

			testCases--;
		}
		//in.close();
	}

}
