package samples.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
	/*
	 * Given an array nums of size n, return the majority element.
	 * 
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
	 * may assume that the majority element always exists in the array.
	 */
	// hashMap approach
	public static int majorityElementHash(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // value , count
		int max = -1;
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (max < map.get(nums[i])) {
				max = map.get(nums[i]);
				ans = nums[i];
			}
		}
		return ans;
	}

	// using voters algo as we know majority element occurs more than half
	public static int majorityElement(int[] nums) {
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else
				count--;

		}
		return major;
	}

	// Given an integer array of size n, find all elements that appear more than
	// n/3 times. can use majority voting here as well but it get complex for more
	// than 2 candidates
	public static List<Integer> majorityElement2(int[] nums) {
		int n = nums.length;
		int passCount = n / 3;
		List<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
		}
		ans = hash.keySet().stream().filter(key -> hash.get(key) > passCount).collect(Collectors.toList());

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };
		System.out.println(majorityElement2(nums));
	}
}
