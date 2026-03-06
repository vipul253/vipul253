package samples.general;

import java.util.Arrays;

public class FirstAndLastPosOfElement {

	/*
	 * Given an array of integers nums sorted in non-decreasing order, find the
	 * starting and ending position of a given target value.
	 * 
	 * If target is not found in the array, return [-1, -1].
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 */
	// Q is find first and last occurrence (binary search on array)
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 4, 4, 6, 7 };
		int[] ans = searchRange(nums, 4);
		int[] ans2 = searchRangeBinary(nums, 4);
		System.out.println(Arrays.toString(ans));
		System.out.println(Arrays.toString(ans2));
	}

	// general approach works on non-sorted as well
	public static int[] searchRange(int[] nums, int target) {
		int first = -1;
		int last = -1;
		boolean firstFind = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target && firstFind) {
				first = i;
				last = i;
				firstFind = false;
			} else if (nums[i] == target) {
				last = i;
			}
		}
		return new int[] { first, last };
	}

	// specific approach because list is sorted
	public static int[] searchRangeBinary(int[] nums, int target) {
		int first = binarySearchLeft(nums,target);
		int last = binarySearchRight(nums,target);
		return new int[] { first, last };
	}

	// Search First Occurrence i.e left side val
	public static int binarySearchLeft(int[] arr, int target) {

		int start = 0;
		int index = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = start + (end - start) / 2;
			// storing target and the checking again in left part by end = middle - 1;
			if (arr[middle] == target) {
				index = middle;
				end = middle - 1;
			}
			if (arr[middle] < target)
				start = middle + 1;
			else if (arr[middle] > target)
				end = middle - 1;
		}
		return index;
	}

	// Search First Occurrence i.e left side val
	public static int binarySearchRight(int[] arr, int target) {

		int start = 0;
		int index = -1;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = start + (end - start) / 2;
			// storing target and the checking again in right part by start = middle + 1;
			if (arr[middle] == target) {
				index = middle;
				start = middle + 1;
			}
			if (arr[middle] < target)
				start = middle + 1;
			else if (arr[middle] > target)
				end = middle - 1;
		}
		return index;
	}

}
