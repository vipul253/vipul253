package samples.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintEvenOddJavaStreams {

	public static void main(String[] args) {
		// Sample array
		int[] numArray = { 1, 2, 3, 4, 2, 3, 1, 6 };
		// int[] to Integer List needs .boxed()
		List<Integer> numbers = Arrays.stream(numArray).boxed().toList();

		// Filter even odd
		// stream->filter->collect
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even numbers: " + evenNumbers);

		// Filter odd numbers
		List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		System.out.println("Odd numbers: " + oddNumbers);
	}

}
