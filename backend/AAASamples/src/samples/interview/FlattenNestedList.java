package samples.interview;

import java.util.ArrayList;
import java.util.List;

public class FlattenNestedList {
	public static void main(String[] args) {
		Object[] array = { 1, 2, new Object[] { 3, 4, new Object[] { 5 }, 6 }, 7 };

		List<Integer> result = flatten(array);
		System.out.println(result); // Output: [1, 2, 3, 4, 5, 6, 7]
	}

	public static List<Integer> flatten(Object[] array) {
		List<Integer> flatList = new ArrayList<>();
		for (Object element : array) {
			if (element instanceof Object[]) {
				// Recursive call for nested arrays
				flatList.addAll(flatten((Object[]) element));
			} else {
				flatList.add((Integer) element);
			}
		}
		return flatList;
	}
}
