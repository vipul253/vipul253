package samples.interview;

import java.util.HashSet;

public class HashSetTrickyConfusion {

	public static void main(String[] args) {
		HashSet<Student> studentList = new HashSet<>();
		Student st1 = new Student("Nimit", 1);
		Student st2 = new Student("Rahul", 3);
		Student st3 = new Student("Nimit", 2);
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
		System.out.println(studentList.size());// 3
		System.out.println(studentList);
		st1.id = 2;
		// we break the uniqueness of hashSet here as Student fields are public and
		// mutable, java is pas by reference so st1 object and st1 added to list both
		// point to same location
		System.out.println(studentList.size());// 2
		System.out.println(studentList);
	}
}
