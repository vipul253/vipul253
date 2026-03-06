package samples.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	/*
	 * Given an integer array nums that may contain duplicates, return all possible
	 * subsets (the power set).
	 * 
	 * The solution set must not contain duplicate subsets. Return the solution in
	 * any order.
	 */
	private static void backtrack(int[] candidates, int startIndex, List<Integer> currentCombination,
			List<List<Integer>> result) {

		// new ArrayList is required because the one passed is being modified in
		// recursion and for loop below
		result.add(new ArrayList<>(currentCombination));

		// Explore each candidate from startIndex
		for (int i = startIndex; i < candidates.length; i++) {
			// Add this check for duplicate values in array
			if (i > startIndex && candidates[i] == candidates[i - 1])
				continue;
			// Pick: Add current candidate
			currentCombination.add(candidates[i]);
			// Pick and call next pass i+1
			backtrack(candidates, i + 1, currentCombination, result);
			// not Pick case with next in loop Backtrack: Remove last added candidate
			currentCombination.remove(currentCombination.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums); // Sort to have duplicates next to each other
		backtrack(nums, 0, new ArrayList<Integer>(), ans);
		System.out.println(ans);
	}
}
