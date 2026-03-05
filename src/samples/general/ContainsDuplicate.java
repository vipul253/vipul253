package samples.general;

import java.util.HashSet;

public class ContainsDuplicate {
	/*
	 * Given an integer array nums, return true if any value appears at least twice
	 * in the array, and return false if every element is distinct. 
	 * Constraints: 
	 * 1 <= nums.length <= 105 
	 * -109 <= nums[i] <= 109
	 */
	
	// can also use double for loop to check all cases.
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>((int) (nums.length / 0.75f) + 1);
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}

}
