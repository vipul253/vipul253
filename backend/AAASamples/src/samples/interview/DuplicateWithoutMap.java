package samples.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWithoutMap {

	// without collections or Map print all duplicates;
	// sort given list and use answer list as the tracker
	// skip 1st element as we compare with one previous element
	// if 1st element is duplicate then it will be caught anyway
	// to avoid adding duplicate twice in answer check the last inserted element
	// GG time complexity depends on sorting algo
	public static int[] duplicateWithoutMap(int[] nums) {
		int j = 1;
		Arrays.sort(nums);
		int n = nums.length;
		int[] ans = new int[n + 1];
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i - 1] && ans[j - 1] != nums[i]) {
				ans[j++] = nums[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 2, 5, 5, 6, 8, 9, 2, 4, 3, 8 };
		System.err.println(Arrays.toString(duplicateWithoutMap(nums)));
		findDuplicatestp(nums);
	}
	
	//this works only if elements are in 1,n range for given n length array;
	public List<Integer> findDuplicatesLeetCode(int[] nums) {
		int n = nums.length;
		int[] hash = new int[n + 1];
		List<Integer> dup = new ArrayList<>();
		for (int i = 0; i < n; i++) {
            if(hash[nums[i]]==-1){
                dup.add(nums[i]);
            }
            hash[nums[i]] = -1;
		}
		return dup;
    }
	
	//using map and collecting duplicates to list by stream
	public List<Integer> findDuplicates(int[] nums) {
		int n = nums.length;
		Map<Integer,Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
		}
		List<Integer> dup = hash.entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		return dup;
    }
	
	//alternate slower than above
	public static List<Integer> findDuplicatestp(int[] nums) {
		int n = nums.length;
		Map<Integer,Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
		}
        // Remove entries where the value is greater than 1
        hash.entrySet().removeIf(entry -> entry.getValue() == 1);
		List<Integer> dup = new ArrayList<>(hash.keySet());
		System.out.println(dup);
		return dup;
    }

}
