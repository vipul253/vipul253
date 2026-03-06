package samples.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	/*
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0. Notice that the solution set must not contain duplicate
	 * triplets.
	 */

	// optimal approach, can also be done with 3 for loops for i j k;
	public static List<List<Integer>> threeSum(int[] nums) {
		if(nums==null || nums.length<3)
			return new ArrayList<List<Integer>>();
		
		Set<List<Integer>> ans = new HashSet<>();
		Arrays.sort(nums);
		int l = nums.length;
		for (int i = 0; i < l - 2; i++) { // -2 bcos j and k need last 2 index
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = l - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (left < right && nums[right] == nums[right + 1])
						right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return new ArrayList<List<Integer>>(ans);
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, 1, 0 }; // target sum is 0
		System.out.println(threeSum(nums));
	}
}
