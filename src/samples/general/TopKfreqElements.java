package samples.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKfreqElements {

	/*
	 * Given an integer array nums and an integer k, return the k most frequent
	 * elements. You may return the answer in any order.
	 * 
	 */
	public int[] topKFrequent(int[] nums, int k) {
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		Map<Integer, Integer> freqMap = new HashMap<>();

		//make a hash of frequencies
		for (int i : nums) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}

		//put elements in an bucket array as per frequency
		for (int key : freqMap.keySet()) {
			int freq = freqMap.get(key);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}

		//loop frequency bucket to output answer
		int[] ans = new int[k];
		int counter = 0;
		for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
			if (bucket[pos] != null) {
				for (Integer num : bucket[pos]) {
					ans[counter++] = num;
				}
			}
		}
		return ans;

	}
}
