package samples.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	/*
	 * 1 Given an array nums of distinct integers, return all the possible
	 * permutations. You can return the answer in any order.
	 * 
	 * 2 Given a collection of numbers, nums, that might contain duplicates, return
	 * all possible unique permutations in any order.
	 * 
	 * Example 1: has duplicate 1
	 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1], [2,1,1]] 
	 * 
	 * Example 2:
	 * Input: nums = [1,2,3] Output:
	 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * 
	 */
	private static void backtrack(int[] mainSet, List<Integer> tempSet, List<List<Integer>> result, boolean[] used) {

		// Base case: Found a valid combination
		if (tempSet.size() == mainSet.length) {
			result.add(new ArrayList<>(tempSet));
			return;
		}

		// Explore each candidate from startIndex
		for (int i = 0; i < mainSet.length; i++) {
			// Add this check for skipping existing values in tempSet
			if (used[i])
				continue;
			// to handle duplicates add this
			if (i > 0 && mainSet[i] == mainSet[i - 1] && !used[i - 1])
				continue;

			// if not used then mark used now
			used[i] = true;
			// Pick: Add current candidate
			tempSet.add(mainSet[i]);
			// Pick and call next pass
			backtrack(mainSet, tempSet, result, used);
			// not Pick case with next in loop Backtrack: Remove last added candidate
			tempSet.remove(tempSet.size() - 1);
			// reset to false as candidate was removed and can be used again
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		// pass extra used array to speed up skipping duplicates
		backtrack(nums, new ArrayList<Integer>(), ans, new boolean[nums.length]);
		System.out.println(ans);
	}
}
