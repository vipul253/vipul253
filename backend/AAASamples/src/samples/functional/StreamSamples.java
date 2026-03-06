package samples.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSamples {
	public static void main(String[] args) {
		// feature introduced in Java 8
		// process collections of data in a functional and declarative manner
		// Simplify Data Processing
		// Embrace Functional Programming
		// Improve Readability and Maintainability
		// Enable Easy Parallelism

		//// What is stream ?
		// a sequence of elements supporting functional and declarative programing

		//// How to Use Streams ?
		// Source, intermediate operations & terminal operation

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

		//// Creating Streams
		// 1. From collections
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Stream<Integer> stream = list.stream();
		// 2. From Arrays
		String[] array = { "a", "b", "c" };
		Stream<String> stream1 = Arrays.stream(array);
		// 3. Using Stream.of()
		Stream<String> stream2 = Stream.of("a", "b");
		// 4. Infinite streams
		Stream.generate(() -> 1);
		Stream.iterate(1, x -> x + 1);

		// Lazy Evaluation
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
		
		Stream<String> stream3 = names.stream().filter(name -> {
			System.out.println("Filtering: " + name);
			return name.length() > 3;
		});

		System.out.println("Before terminal operation");

		List<String> result = stream3.collect(Collectors.toList());

		System.out.println("After terminal operation");
		System.out.println(result);

		//Primitive streams of int double long etc.
		int[] numbers1 = { 1, 2, 3, 4, 5 };
		IntStream stream5 = Arrays.stream(numbers1);

		System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
		System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

		IntStream.of(1, 2, 3);

		DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.sum());
//        System.out.println(doubles.min());
//        System.out.println(doubles.max());
//        System.out.println(doubles.average());
//        doubles.summaryStatistics()
//        doubles.mapToInt(x -> (int) (x + 1));
		System.out.println(doubles.boxed().toList());

		IntStream intStream = new Random().ints(5);
		System.out.println(intStream.boxed().toList());

	}
}
