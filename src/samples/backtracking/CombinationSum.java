package samples.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	/*
	 * Given an array of distinct integers candidates and a target integer target,
	 * return a list of all unique combinations of candidates where the chosen
	 * numbers sum to target. You may return the combinations in any order.
	 * 
	 * The same number may be chosen from candidates an unlimited number of times.
	 * Two combinations are unique if the frequency of at least one of the chosen
	 * numbers is different.
	 * 
	 * The test cases are generated such that the number of unique combinations that
	 * sum up to target is less than 150 combinations for the given input.
	 */

	// recursion based
	private static void backtrack(int[] candidates, int startIndex, int remainingSum, List<Integer> tempSet,
			List<List<Integer>> result, boolean[] used) {

		// Base case: Found a valid combination
		if (remainingSum == 0) {
			result.add(new ArrayList<>(tempSet));
			return;
		} else if (remainingSum < 0) {
			// Pruning: If remaining sum is less than smallest candidate, no point
			// continuing
			return;
		}
		// Explore each candidate from startIndex onward
		for (int i = startIndex; i < candidates.length; i++) {
			if(used[i])
				continue;
			if (i > startIndex && candidates[i] == candidates[i - 1] && !used[i-1])
				continue; // skip duplicates
			used[i] = true;
			// Pick: Add current candidate
			tempSet.add(candidates[i]);
			// Recurse: Allow reuse by passing 'i' (not i+1)
			// case 2 no duplicate allowed so pass i + 1
			backtrack(candidates, i + 1, remainingSum - candidates[i], tempSet, result, used);
			// not Pick then Backtrack so Remove last added candidate
			tempSet.remove(tempSet.size() - 1);
			used[i] = false;
		}

	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 2, 1, 2 };
		int target = 5;

		List<List<Integer>> ans = new ArrayList<>();
		//Arrays.sort(nums); // Sort for early pruning, 
		int[]temparr=new int[nums.length];
		mergeSort(0,nums.length-1,nums,temparr);
		//used merge sort separately as it slows down for combination sum II 
		backtrack(nums, 0, target, new ArrayList<Integer>(), ans, new boolean[nums.length]);
		System.out.println(ans);
	}
	
	//condensed merge sort
	private static void mergeSort(int l,int r,int[] arr,int[] temp){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(l,mid,arr,temp);
            mergeSort(mid+1,r,arr,temp);
            merge(l,r,mid,arr,temp);
        }
    }
    private static void merge(int i,int j,int mid,int[] arr,int[] temp){
        int l=i,r=mid+1,index=i;
        while(l<=mid && r<=j){
            if(arr[l]<arr[r])temp[index++]=arr[l++];
            else temp[index++]=arr[r++];
        }
        while(l<=mid)temp[index++]=arr[l++];
        while(r<=j)temp[index++]=arr[r++];
        for(;i<=j;i++)arr[i]=temp[i];
    }
}
