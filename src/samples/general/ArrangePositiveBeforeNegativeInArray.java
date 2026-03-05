package samples.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangePositiveBeforeNegativeInArray {
	/*
	 * 49. Arrange array with positive integers before negatives
	 * 
	 * Write a Java program to arrange the elements of an array of integers so that
	 * all positive integers appear before all negative integers.
	 * 
	 */
	public static void main(String[] args) {
		int[] nums = { -3, -2, -4, 5, 6, 4, 1, 3, -1 };
		// rearrangeArray1(nums);
		// rearrangeArray2(nums);
		nums = rearrangeArray5(nums);
		System.out.println(Arrays.toString(nums));
	}

	// for all positive on left and negative on right, preserves order
	public static int[] rearrangeArray1(int[] nums) {
		int n = nums.length;
		int[] positive = new int[n / 2 + 1];
		int[] negative = new int[n / 2 + 1];
		int pIdx = 0, nIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				negative[nIdx++] = nums[i];
			} else {
				positive[pIdx++] = nums[i];
			}
		}
		for (int i = 0; i < pIdx; i++) {
			nums[i] = positive[i];
		}
		for (int i = 0; i < nIdx; i++) {
			nums[pIdx + i] = negative[i];
		}
		return nums;
	}

	// for all positive on left and negative on right,
	// no extra array needed, preserves order
	public static int[] rearrangeArray2(int[] nums) {
		int j, temp, n;
		n = nums.length;
		for (int i = 0; i < n; i++) {
			j = i;
			// Shift positive numbers to the left and negative numbers to the right.
			while ((j > 0) && (nums[j] > 0) && (nums[j - 1] < 0)) {
				temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
				j--;
			}
		}
		return nums;
	}

	/*
	 * You are given a 0-indexed integer array nums of even length consisting of an
	 * equal number of positive and negative integers.
	 * 
	 * You should return the array of nums such that the array follows the given
	 * conditions:
	 * 
	 * Every consecutive pair of integers have opposite signs. For all integers with
	 * the same sign, the order in which they were present in nums is preserved. The
	 * rearranged array begins with a positive integer. Return the modified array
	 * after rearranging the elements to satisfy the aforementioned conditions.
	 */
	// for all positive & negative alternating starting from positive,
	// preserves order, array size is even and -ve count == +ve count
	public static int[] rearrangeArray3(int[] nums) {
		int n = nums.length;
		int[] positive = new int[n / 2];
		int[] negative = new int[n / 2];
		int pIdx = 0, nIdx = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				negative[nIdx++] = nums[i];
			} else {
				positive[pIdx++] = nums[i];
			}
		}
		for (int i = 0; i < n / 2; i++) {
			nums[i * 2] = positive[i];
			nums[i * 2 + 1] = negative[i];
		}
		return nums;
	}

	// for all positive & negative alternating starting from positive,
	// preserves order, array size is even and -ve count == +ve count
	public static int[] rearrangeArray4(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int pIdx = 0, nIdx = 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				ans[nIdx] = nums[i];
				nIdx += 2;
			} else {
				ans[pIdx] = nums[i];
				pIdx += 2;
			}
		}
		return ans;
	}

	// for all positive & negative alternating starting from positive,
	// preserves order, array size is not even and -ve count != +ve count
	public static int[] rearrangeArray5(int[] nums) {
		int n = nums.length;
		List<Integer> positive = new ArrayList<>();
		List<Integer> negative = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				negative.add(nums[i]);
			} else {
				positive.add(nums[i]);
			}
		}
		
		int alternatingLen = positive.size();
		if (negative.size() < positive.size()) {
			alternatingLen = negative.size();
		}
		for (int i = 0; i < alternatingLen; i++) {
			nums[i * 2] = positive.get(i);
			nums[i * 2 + 1] = negative.get(i);
		}
		int index = alternatingLen*2;
		for (int i = alternatingLen; i < positive.size(); i++) {
			nums[index] = positive.get(i);
			index++;
		}
		for (int i = alternatingLen; i < negative.size(); i++) {
			nums[index] = negative.get(i);
			index++;
		}
		return nums;
	}

}
