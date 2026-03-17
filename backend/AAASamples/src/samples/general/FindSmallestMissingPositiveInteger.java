package samples.general;

import java.util.HashSet;
import java.util.Set;

public class FindSmallestMissingPositiveInteger {

	/*
	 * Given an unsorted integer array nums. Return the smallest positive integer
	 * that is not present in nums.
	 * 
	 * You must implement an algorithm that runs in O(n) time and uses O(1)
	 * auxiliary space.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,0] Output: 3 Explanation: The numbers in the range [1,2]
	 * are all in the array.
	 */

	public static int firstMissingPositive(int[] nums) {

		int n = nums.length;
		int ans = 1;
		Set<Integer> hash = new HashSet<>();
		// this won't work on LeetCode saying Memory exceeded
		// BitSet hash = new BitSet();
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0)
				continue;
			hash.add(nums[i]);
		}
		while (hash.contains(ans)) {
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 100000, 3, 4000, 2, 15, 1, 99999 };
		System.out.println(firstMissingPositive(nums));
	}

}
