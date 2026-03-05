package samples.general;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	/*
	 * Given an integer array nums, return an array answer such that answer[i] is
	 * equal to the product of all the elements of nums except nums[i].
	 * 
	 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
	 * integer.
	 * 
	 * You must write an algorithm that runs in O(n) time and without using the
	 * division operation.
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
	
	// optimal approach
	public static int[] productExceptSelf(int[] nums) {
		// sample nums = [1,2,3,4]
		int[] ans = new int[nums.length];
		int currProd = 1;
		// prefix directly on ans[]
		for (int i = 0; i < nums.length; i++) {
			ans[i] = currProd;
			currProd = currProd * nums[i];
		}
		// after above loop ans = [1,1,2,6]
		currProd = 1; // reset to 1 for suffix loop
		// suffix loop on ans[]
		for (int i = nums.length - 1; i >= 0; i--) {
			// remember to multiply with prefix in ans[] before nums[]
			ans[i] = currProd * ans[i];
			currProd = currProd * nums[i];
		}
		return ans;
	}

	// prefix prod and suffix prod then fill ans with prefix*suffix
	public static int[] productExceptSelfBetter(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int[] prefix = new int[n];
		int[] suffix = new int[n];

		// prefix
		prefix[0] = 1;
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] * nums[i - 1];
		}
		// suffix
		suffix[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * nums[i + 1];
		}
		// prefix*suffix TC = O(3n)
		for (int i = 0; i < n; i++) {
			ans[i] = prefix[i] * suffix[i];
		}
		return ans;
	}

	// brute force double loop gives TLE
	public static int[] productExceptSelfBF(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		for (int i = 0; i < nums.length; i++) {
			int prod = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					prod = prod * nums[j];
				}
			}
			ans[i] = prod;
		}
		return ans;
	}

}
