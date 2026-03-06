package samples.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	public static void backtrack(int start, int openN, int closeN, int n, List<String> ans, char[] s) {
		if (start == 2 * n) {
			ans.add(new String(s));
			return;
		}
		if (openN < n) {
			s[start] = '(';
			backtrack(start + 1, openN + 1, closeN, n, ans, s);
		}
		if (closeN < openN) {
			s[start] = ')';
			backtrack(start + 1, openN, closeN + 1, n, ans, s);
		}
	}

	public static void main(String[] args) {
		// only add open parenthesis if open < n
		// only add close parentesis if open > close
		// valid if open == close == n --> base case

		int n = 3;
		List<String> ans = new ArrayList<>();
		char[] s = new char[n * 2];
		backtrack(0, 0, 0, n, ans, s);
		System.out.println(ans);
	}

	// validate given parenthesis string
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(')
				stack.push(')');
			else if (ch == '[')
				stack.push(']');
			else if (ch == '{')
				stack.push('}');
			else if (stack.isEmpty() || stack.pop() != ch)
				return false;
		}

		return stack.isEmpty();
	}
}
