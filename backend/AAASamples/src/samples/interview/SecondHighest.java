package samples.interview;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighest {

	public static int findSecondHighest(int[] arr) {
		if (arr.length < 2)
			return arr[0];
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num > highest) {
				// Current becomes highest, old highest moves to second
				secondHighest = highest;
				highest = num;
			} else if (num > secondHighest && num != highest) {
				// Current is between highest and second highest
				secondHighest = num;
			}
		}
		return secondHighest;
	}

	public static void main(String[] args) {
		int[] numbers = { 10, 5, 20, 8, 20, 15 };
		System.out.println("Second highest: " + findSecondHighest(numbers)); // Output: 15
		secondHighestByStreams(numbers); // Output: 15
	}

	public static void secondHighestByStreams(int[] arr) {

		int secondHighest = Arrays.stream(arr).distinct() // Remove duplicates
				.boxed() // Convert to Integer for sorting
				.sorted(Comparator.reverseOrder()) // Sort descending
				.skip(1) // Skip the highest
				.findFirst() // Get the next element
				.orElseThrow(() -> new RuntimeException("No second highest found"));

		System.out.println("Second highest: " + secondHighest);
	}
}
