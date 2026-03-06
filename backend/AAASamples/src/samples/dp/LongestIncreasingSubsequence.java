package samples.dp;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {

	// To find LongestIncreasingSubsequence by Recursion / DP bottom-up(tabular)
	// lis with recursion 2^n
	public static int lisRec(int[] a) {
		return lisRecUtil(a, 0, -1);
	}

	private static int lisRecUtil(int[] a, int idx, int prevIdx) {
		if (idx > a.length - 1)
			return 0;

		int len = 0 + lisRecUtil(a, idx + 1, prevIdx);

		if (prevIdx == -1 || a[idx] > a[prevIdx])
			len = Math.max(len, 1 + lisRecUtil(a, idx + 1, idx));

		return len;
	}

	// lis with recursion 2^n
	public static int lisRecMemo(int[] a, int l) {
		int[][] dp = new int[l][l + 1];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return lisRecUtilMemo(a, 0, -1, dp);
	}

	private static int lisRecUtilMemo(int[] a, int idx, int prevIdx, int[][] dp) {

		if (idx > a.length - 1)
			return 0;
		if (dp[idx][prevIdx + 1] != -1)
			return dp[idx][prevIdx + 1];

		int len = 0 + lisRecUtilMemo(a, idx + 1, prevIdx, dp);

		if (prevIdx == -1 || a[idx] > a[prevIdx])
			len = Math.max(len, 1 + lisRecUtilMemo(a, idx + 1, idx, dp));

		dp[idx][prevIdx + 1] = len;

		return len;
	}

	// lis with DP[][]
	public static int lisDP(int[] a) {
		int n = a.length;
		int dp[][] = new int[n + 1][n + 1];

		for (int idx = n - 1; idx >= 0; idx--) {
			for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
				int len = 0 + dp[idx + 1][prevIdx + 1];
				if (prevIdx == -1 || a[idx] > a[prevIdx])
					len = Math.max(len, 1 + dp[idx + 1][idx + 1]);
				dp[idx][prevIdx + 1] = len;
			}
		}

		return dp[0][0];
	}

	// lis with DP[] tabular/bottom-up optimised
	public static int lisMain(int[] a) {
		int n = a.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		Arrays.sort(dp);
		return dp[n - 1];
	}

	// lis with DP[] tabular/bottom-up optimised with printing LIS logic
	public static int lisWithPrint(int[] a) {
		int n = a.length;
		int dp[] = new int[n];
		int hash[] = new int[n];
		int max = 1;
		int maxIndex = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			hash[i] = i;
			for (int prev = 0; prev < i; prev++) {
				if (a[i] > a[prev] && 1 + dp[prev] > dp[i]) {
					dp[i] = dp[prev] + 1;
					hash[i] = prev;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				maxIndex = i;
			}
		}
		// LIS indexes stored in hash[] now print after storing in result
		int[] result = new int[maxIndex - 1];
		int nextIndex = maxIndex;
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = a[nextIndex];
			nextIndex = hash[nextIndex];
		}
		System.out.println(Arrays.toString(result));
		return max;
	}

	// Binary Search solution
	public static int lengthOfLIS(int[] nums) {
		List<Integer> sequence = new ArrayList<>();
		for (int num : nums) {
			//if element found gives index if not found gives insertion index
			int index = Collections.binarySearch(sequence, num);
			if (index < 0)
				index = -(index + 1);
			if (index == sequence.size()) {
				sequence.add(num);
			} else {
				sequence.set(index, num);
			}
		}
		return sequence.size();
	}

	public static void main(String[] args) {

		// Scanner in = new Scanner(System.in);
		// lis 2 4 5 8 9 of length 5
		int[] n = { 2, 1, 4, 45, 5, 8, 9 };
		int l = n.length;
		System.out.println(lisRec(n));
		System.out.println(lisRecMemo(n, l));
		System.out.println(lisDP(n));
		System.out.println(lisMain(n));
		System.out.println(lisWithPrint(n));
		System.out.println(lengthOfLIS(n));
		// in.close();
	}
}
