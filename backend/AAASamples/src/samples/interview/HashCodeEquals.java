package samples.interview;

import java.util.Objects;

public class HashCodeEquals {
	private String name;
	private int age;

	public HashCodeEquals(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		// 1. Check for reference equality (optimization)
		if (this == obj)
			return true;
		// 2. Check for null and type compatibility
		if (obj == null || getClass() != obj.getClass()) 
			return false;
		
		// 3. Cast the object to the correct type
		HashCodeEquals person = (HashCodeEquals) obj;
		// 4. Compare significant fields using utility methods or '==' for primitives
		return age == person.age && Objects.equals(name, person.name); // Use Objects.equals for null-safe comparison of
	}

	@Override
	public int hashCode() {
		// Combine hash codes of the same fields used in equals()
		return Objects.hash(name, age);
		// Alternatively, a manual implementation using a prime number (e.g., 31)
		/*
		 * int result = (name == null) ? 0 : name.hashCode(); result = 31 * result +
		 * age; return result;
		 */
	}
}
