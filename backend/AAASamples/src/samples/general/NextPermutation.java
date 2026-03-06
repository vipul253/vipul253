package samples.general;

import java.util.Arrays;

public class NextPermutation {
	/*
	 * A permutation of an array of integers is an arrangement of its members into a
	 * sequence or linear order.
	 * 
	 * For example, for arr = [1,2,3], the following are all the permutations of
	 * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]. The next
	 * permutation of an array of integers is the next lexicographically greater
	 * permutation of its integer
	 */

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
		
	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		int cutIndex = -1;
		for(int i=n-2; i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				cutIndex = i;
				break;
			}
		}
		
		if(cutIndex!=-1) {
			for(int i=n-1; i>=0;i--) {
				if(nums[i]>nums[cutIndex]) {
					swap(nums,i,cutIndex);
					break;
				}
			}
		}
		//if cut is still -1 then given nums was last permutation e.g [321]
		//so reverse it and return 1st permutation i.e [123]
		//elements till cutIndex were increasing so after swap we can reverse rest part
		//to get the next larger permute which is the smallest;
		reverse(nums,cutIndex+1);
	}

	private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
