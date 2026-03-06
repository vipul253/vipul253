package samples.java;

import java.util.Scanner;

public class ValidateRegex {

	//checks if given regex is proper
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int testCases = Integer.parseInt(in.nextLine());
		int testCases = 1;
		// to find if regex pattern is valid or not
		while (testCases > 0) {
			String pattern = "[AZ[a-z](a-z)"; //in.nextLine();
			try {
				"".split(pattern);
				// split method throws error if pattern is invalid
				// Pattern.compile(pattern); // was not giving error for [AZ[a-z](a-z) which is
				// missing a bracket.
				System.out.println("Valid");

			} catch (Exception e) {
				System.out.println("Invalid");
			}
			testCases--;
		}
		in.close();
	}
}
