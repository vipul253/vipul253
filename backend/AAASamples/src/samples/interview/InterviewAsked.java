package samples.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewAsked {
	
	public static void main(String[] args) {
		int[] nums= {1,1,2,2,3,3,4,4,5,6,7};
		System.out.println(findNonRepeating(nums));
	}
	public static List<Integer> findNonRepeating(int[] nums){
		Map<Integer,Integer> hash = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
		}
		List<Integer> answer = hash.keySet().stream().filter(x -> hash.get(x)==1).collect(Collectors.toList());
		return answer;
	}
}
