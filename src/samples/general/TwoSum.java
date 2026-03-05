package samples.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/*
	 * Given an array of integers nums and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * You can return the answer in any order.
	 */
	
	// using hashMap to store prev values and their index
	public static boolean twoSumYN(int[] n, int T) {
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < n.length; i++) {
			int reqNum = T - n[i];
			if (hash.containsKey(reqNum))
				return true;
			else
				hash.put(n[i], i);
		}
		return false;
	}

	public static int[] twoSumIndex(int[] n, int T) {
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < n.length; i++) {
			int reqNum = T - n[i];
			if (hash.containsKey(reqNum))
				return new int[] { hash.get(reqNum), i };
			else
				hash.put(n[i], i);
		}
		return null;
	}

	// YES NO using two pointer, this will be used in solving 3sum 
	public static boolean twoSumYNOptimal(int[] n, int T) {
		int i = 0;
		int j = n.length - 1;
		Arrays.sort(n); // sorted array reqd for this approach
		while (i < j) {
			int sum = n[i] + n[j];
			if (sum == T)
				return true;
			if (sum > T)
				j--;
			else
				i++;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 8, 9 };
		int targetSum = 14;
		System.out.println(twoSumYN(nums, targetSum));
		System.out.println(twoSumIndex(nums, targetSum));
	}
}
