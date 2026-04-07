package samples.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineArrayListFlatMap {

	public static void main(String[] args) {
		List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
		
		System.out.println(listOfLists.stream()
				.flatMap(t -> t.stream())//stream the nested lists
				.distinct()// remove duplicate
				.collect(Collectors.toList())//collect in new list
		);
	}
}
