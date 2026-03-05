package samples.dp;

public class MaxSubArraySumKadan {
	/*
	 * Given an integer array nums, find the subarray with the largest sum, and
	 * return its sum. use double loop or kadan's algo
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: The subarray
	 * [4,-1,2,1] has the largest sum 6.
	 * 
	 * Kadan's Algo Kadane's Algorithm is a dynamic programming approach used to
	 * solve the maximum subarray problem—finding the contiguous subarray within a
	 * one-dimensional array of numbers that has the largest sum.
	 * 
	 * It operates in O(n) time complexity with O(1) space complexity, making it
	 * highly efficient. The algorithm iterates through the array once, Start fresh
	 * from the current element, if the previous sum is negative
	 */
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArrayKadanAlgo(nums));
	}

	// Double loop brute force will give TLE
	public static int maxSubArray(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int currSum = 0;
			for (int j = i; j < nums.length; j++) {
				currSum = currSum + nums[j];
				maxSum = Math.max(currSum, maxSum);
			}
		}
		return maxSum;
	}

	public static int maxSubArrayKadanAlgo(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum = curSum + nums[i];
			maxSum = Math.max(curSum, maxSum);
			if (curSum < 0)
				curSum = 0;
		}
		return maxSum;
	}
}
