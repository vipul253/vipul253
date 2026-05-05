package samples.functional;

import java.util.*;
import java.util.stream.Collectors;

public class streamsDemo {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee(101, "Alice Smith", 30, 75000.0, "Manager", "Female", "QC"),
				new Employee(102, "Bob Jones", 25, 85000.0, "Developer", "Male", "DEV"),
				new Employee(103, "Charlie Brown", 27, 65000.0, "Tester", "Male", "QC"),
				new Employee(104, "Daisy Smith", 37, 88000.0, "Developer", "Female", "DEV"),
				new Employee(105, "Edward Jones", 26, 64000.0, "Manager", "Male", "SUPPORT"),
				new Employee(106, "Frank Brown", 23, 35000.0, "Tester", "Male", "QC"),
				new Employee(107, "Grace Smith", 34, 58000.0, "Developer", "Female", "SUPPORT"),
				new Employee(108, "Henry Karen", 30, 75000.0, "Manager", "Male", "DEV"),
				new Employee(109, "Ian Paul", 32, 65000.0, "Developer", "Male", "SUPPORT"),
				new Employee(110, "Jennifer Bane", 40, 78000.0, "Developer", "Female", "DEV"),
				new Employee(111, "Kate Cloud", 40, 52000.0, "Manager", "Female", "HR"),
				new Employee(112, "Lisa Hunt", 25, 35000.0, "Recruiter", "Female", "HR"));

		System.out.println("============================================");
		List<Employee> top5Sal = empList.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary())).limit(5)
				.collect(Collectors.toList());// don't use comparator for double and then reverse as it is less optimal
		System.out.println("Top 5 salaried Employee: ");
		System.out.println(top5Sal);

		System.out.println("============================================");
		Optional<Employee> eldest = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("Eldest employee: ");
		eldest.ifPresent(System.out::println);// what if there are multiple with same age, so take a list.

		System.out.println("============================================");
		Map<String, Double> expenseByDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println("total expenditure department wise:");
		System.out.println(expenseByDept);

		System.out.println("\n============================================");
		Map<String, Long> maleToFemaleCount = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Total number of males & females working in company:");
		System.out.println(maleToFemaleCount);

		System.out.println("\n============================================");
		Map.Entry<String, Integer> lowestAgeDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getAge)))
				.entrySet().stream().min((a, b) -> a.getValue() - b.getValue()).orElseThrow();
		System.out
				.println("Youngest Department :" + lowestAgeDept.getKey() + " Total Age: " + lowestAgeDept.getValue());

		System.out.println("\n============================================");
		long totalEmpCount = empList.size(); // dont use stream for everything.
		System.out.println("Total employee count: " + totalEmpCount);
	}
}
