package samples.general;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestDangerousRange {

	/*
	 * You have been given an array/list HEIGHT denoting the heights of ‘N’ adjacent
	 * hills. The hills are said to be dangerous if their heights are turbulent.
	 * 
	 * A range of hills is turbulent if the comparison sign for their heights flips
	 * between each adjacent pair of hills. For example, if HEIGHT = [1, 2, 10, 3,
	 * 5, 1, 10, 10], then the hills in index range [1, 6] are turbulent as
	 * 
	 * 2 < 10 > 3 < 5 > 1 < 10
	 * 
	 * Your task is to find the length of the longest dangerous hill range.
	 */
	public static void main(String[] args) {
		// 88>57=57<76<93>13<45
		ArrayList<Integer> height = new ArrayList<>(Arrays.asList(9, 4, 2, 10, 7, 8, 8, 1, 9));
		// ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1,2,1,4));
		// ArrayList<Integer> height = new ArrayList<>(Arrays.asList(2,8));
		// ArrayList<Integer> height = new ArrayList<>(Arrays.asList(61,61,61));
		System.out.println(longestDangerousRange(height, height.size()));
	}

	public static int longestDangerousRange(ArrayList<Integer> height, int n) {
		if (height.size() == 1)
			return 1;

		int maxLen = 1;
		int currentLen = 1;
		int prevSign = 0; // 0: initial, 1: increasing, -1: decreasing

		for (int i = 1; i < n; i++) {
			int currentSign = 0;
			if (height.get(i) > height.get(i - 1)) {
				currentSign = 1;
			} else if (height.get(i) < height.get(i - 1)) {
				currentSign = -1;
			}

			if (currentSign == 0) {
				currentLen = 1;
			} else if (currentSign != prevSign) {
				currentLen++;
				maxLen = Math.max(maxLen, currentLen);
			} else {
				// Start fresh with last two
				// in-case two adjacent are not equal then
				// we always have min len=2 [2=2<8=8] here it is
				// 2 for diff between 2 and 8
				currentLen = 2;
			}
			prevSign = currentSign;
		}

		return Math.max(maxLen, currentLen);
	}
}
