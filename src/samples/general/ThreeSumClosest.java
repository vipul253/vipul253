package samples.general;

import java.util.Arrays;

public class ThreeSumClosest {
	/*
	 * Given an integer array nums of length n and an integer target, find three
	 * integers at distinct indices in nums such that the sum is closest to target.
	 * Return the sum of the three integers. You may assume that each input would
	 * have exactly one solution. 
	 * Constraints:
	 * 3 <= nums.length <= 500 
	 * -1000 <= nums[i] <= 1000 
	 * -104 <= target <= 104
	 */

	// optimal approach, can also be done with 3 for loops for i j k;
	public static int threeSum(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;

		int resultSum = nums[0] + nums[1] + nums[2];
		int minDiff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int l = nums.length;
		for (int i = 0; i < l - 2; i++) { // -2 bcos j and k need last 2 index
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = l - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return target;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}

				int diffToTarget = Math.abs(sum - target);
				if (diffToTarget < minDiff) {
					resultSum = sum;
					minDiff = diffToTarget;
				}

			}
		}
		return resultSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, 1, 0 };
		int target = 5;
		System.out.println(threeSum(nums, target));
	}
}
