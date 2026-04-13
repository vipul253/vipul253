package samples.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainComparingSample {
	/**
	 * The thenComparing method is used for Chained Sorting. It allows you to define
	 * a secondary sorting rule if the primary rule results in a tie.
	 * 
	 * Primitive Specialization: To avoid autoboxing (better performance), use
	 * specialized methods like thenComparingInt() or thenComparingDouble() Handling
	 * nulls in a sort chain is crucial because if Comparator.comparing encounters a
	 * null value, it will throw a NullPointerException. You can wrap your logic
	 * with Comparator.nullsFirst() or Comparator.nullsLast() to tell Java exactly
	 * where those "missing" values should go.
	 */
	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Charlie", "IT"), new Employee("Alice", "HR"),
				new Employee(null, "IT"), new Employee("Bob", "IT"));// null name 3rd emp

		// Define a name comparator that handles nulls safely
		Comparator<String> nameWithNulls = Comparator.nullsFirst(Comparator.naturalOrder());

		// 1. Sort by Department
		// 2. THEN sort by Name (if departments are equal)
		list.sort(Comparator.comparing(Employee::getDept)
				// Use the null-safe comparator for the name field
				.thenComparing(Employee::getName, nameWithNulls));

		list.forEach(System.out::println);
	}
}

class Employee {
	String name;
	String dept;

	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return dept + ": " + name;
	}
}