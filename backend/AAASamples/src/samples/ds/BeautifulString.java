package samples.ds;

public class BeautifulString {

	/*
	 * Ninja has been given a binary string ‘STR’ containing either ‘0’ or ‘1’. A
	 * binary string is called beautiful if it contains alternating 0s and 1s.
	 * 
	 * For Example:‘0101’, ‘1010’, ‘101’, ‘010’ are beautiful strings.
	 * 
	 * He wants to make ‘STR’ beautiful by performing some operations on it. In one
	 * operation, Ninja can convert ‘0’ into ‘1’ or vice versa.
	 * 
	 * Your task is to determine the minimum number of operations Ninja should
	 * perform to make ‘STR’ beautiful.
	 * 
	 * For Example : Minimum operations to make ‘STR’ ‘0010’ beautiful is ‘1’. In
	 * one operation, we can convert ‘0’ at index ‘0’ (0-based indexing) to ‘1’. The
	 * ‘STR’ now becomes ‘1010’ which is a beautiful string.
	 */

	public static int makeBeautiful(String str) {
		char[] c = str.toCharArray();
		int ans = 0, ans2 = 0;
		// starts with 0
		char st = '0';
		for (char i : c) {
			if (i != st) {
				ans++;
			}
			st = (char) (st ^ 1);
		}
		// starts with 1
		st = '1';
		for (char i : c) {
			if (i != st) {
				ans2++;
			}
			st = (char) (st ^ 1);
		}
		return Math.min(ans, ans2);
	}

	public static void main(String[] args) {
		String str = "101000010101010101000000000111111000000111110001010110101000001111001";
		System.out.println(makeBeautiful(str));
		System.out.println(makeBeautiful2(str));
	}
	
	public static int makeBeautiful2(String str) {
		return Math.min(count(str, '0', 0), count(str, '1', 0));
	}

	public static int count(String str, char st, int ans) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != st) {
				ans++;
			}
			st = (char) (st ^ 1);
		}
		return ans;
	}
}
