package samples.interview;

import java.util.HashSet;
import java.util.Objects;

public class HashSetUniqueKey {

	public static void main(String[] args) {
		HashSet<Person> person = new HashSet<>();

		person.add(new Person(101, "Alice"));
		// Duplicate ID: hashCode will find the same bucket,
		// and equals(101) will return true. It won't be added.
		person.add(new Person(101, "Bob"));

		Person pDup = new Person(103, "Alice");
		person.add(pDup);
		pDup.setId(101);// direct change object reference breaks hashSet unique key
		System.out.println("Unique students count: " + person.size()); // Prints 2
		System.out.println(person);
	}
}

class Person {
	int id;
	String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	// Step 1: Tell Java which bucket to use based on 'id'
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	// Step 2: Define exactly what makes two persons "equal"
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Person p = (Person) obj;
		return id == p.id; // Unique by ID only
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.id+" "+this.name;
	}
}
