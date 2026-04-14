package samples.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class NthHighestSalaryByManagerByDepartment {

	/*
	 * suppose a employee has id, name, managerId, deptId, salary,
	 * write a program to get the employee names with 9th highest salary under each
	 * manager for each department
	 */
	public static void main(String[] args) {
		List<Employi> employees = Arrays.asList(new Employi(16, "Edward", 101, 1, 104273),
				new Employi(17, "Thomas", 101, 1, 102160), new Employi(18, "Steven", 101, 1, 100193),
				new Employi(19, "Christopher", 101, 1, 98214), new Employi(20, "Paul", 101, 1, 96400),
				new Employi(21, "Emily", 101, 1, 94403), new Employi(22, "Jennifer", 101, 1, 92203),
				new Employi(23, "Patricia", 101, 1, 90418), new Employi(24, "Barbara", 101, 1, 88293), // 9th for 101
				new Employi(28, "Robert", 102, 1, 129145), new Employi(29, "Kevin", 102, 1, 127463),
				new Employi(30, "Matthew", 102, 1, 125241), new Employi(31, "Karen", 102, 1, 123454),
				new Employi(32, "John", 102, 1, 121089), new Employi(33, "Lisa", 102, 1, 119187),
				new Employi(34, "Steven", 102, 1, 117104), new Employi(35, "Linda", 102, 1, 115372),
				new Employi(36, "Mary", 102, 1, 113356) // 9th for 102
		);

		// Group by Department and Manager
		Map<String, List<Employi>> grouped = employees.stream()
				.collect(Collectors.groupingBy(e -> e.deptId + "-" + e.managerId));

		grouped.forEach((key, group) -> {
			// Find 9th unique salary
			Optional<Double> ninthSalary = group.stream().map(e -> e.salary).distinct() // for DENSE_RANK() like order
					.sorted(Comparator.reverseOrder()).skip(8) // Skip first 8 to get the 9th
					.findFirst();

			ninthSalary.ifPresent(salary -> {
				group.stream().filter(e -> e.salary == salary)
						.forEach(e -> System.out.println("Group " + key + ": " + e.name));
			});
		});
	}
}

class Employi {
	int id;
	String name;
	Integer managerId;
	int deptId;
	double salary;

	public Employi(int id, String name, Integer managerId, int deptId, double salary) {
		this.id = id;
		this.name = name;
		this.managerId = managerId;
		this.deptId = deptId;
		this.salary = salary;
	}
}