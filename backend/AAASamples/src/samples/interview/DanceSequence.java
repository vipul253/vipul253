package samples.interview;

import java.util.Arrays;

public class DanceSequence {
	/*
	 * Given a sequence of performers numbered based on their popularity in
	 * increasing order, rearrange such that the popularity alternates in a way that
	 * the next performer has a lower popularity and the next after that has higher
	 * popularity, do in-place modification
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		rearrange(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static int[] rearrange(int[] nums) {
		int n = nums.length - 1;
		for (int i = 1; i < n; i += 2) {
			if (nums[i] > nums[i - 1])
				swap(nums, i, i - 1);
			if (nums[i] > nums[i + 1])
				swap(nums, i, i + 1);
		}
		return nums;
	}

	public static void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
}
