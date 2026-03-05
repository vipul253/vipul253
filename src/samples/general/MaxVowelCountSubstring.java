package samples.general;

import java.util.HashSet;
import java.util.Set;

public class MaxVowelCountSubstring {

	//sliding window approach O(n)
	public static int maxVowels(String s, int k) {
		int max = 0;
		int windowMax = 0;
		Set<Character> vow = new HashSet<>();
		vow.add('a');
		vow.add('e');
		vow.add('i');
		vow.add('o');
		vow.add('u');
		
		//count vows in 1st window
		for(int i=0;i<k;i++) {
			if(vow.contains(s.charAt(i))) {
				windowMax++;
			}
		}
		max = windowMax;
		//loop till end from k i.e sliding window by one
		for (int i = k; i < s.length(); i++) {
			if(vow.contains(s.charAt(i-k))) {
				windowMax--;
			}
			if(vow.contains(s.charAt(i))) {
				windowMax++;
			}
			max = Math.max(windowMax, max);
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "weallloveyou";
		int k = 7;
		System.out.println(maxVowels(s, k));

	}
}
