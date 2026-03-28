package samples.java;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String name = null;
		// Safe handling with orElse
		Optional<String> optionalName = Optional.ofNullable(name);
		String finalName = optionalName.orElse("Default Name");
		System.out.println(finalName); // Output: Default Name

		optionalName.filter(n->n.length()>1);
		System.out.println(optionalName.isEmpty());
		// Functional approach with ifPresent
		optionalName.ifPresent(n -> System.out.println(n.length()));
		//will print only if present
	}
}

/*
 * The Optional class, introduced in Java 8, is a container object used to
 * represent a value that may or may not be present. Its primary purpose is to
 * help developers handle potential null values explicitly and avoid the common
 * NullPointerException
 * 
 * What is it and why use it? It is an immutable java.util container that may
 * contain a non-null value or be empty.
 * 
 * It forces callers to handle the absence of a value, replacing risky null
 * checks with cleaner code.
 * 
 * What are key methods? of(T) / ofNullable(T): Creates an Optional. isPresent()
 * / isEmpty(): Checks for existence. get(): Retrieves the value (use caution,
 * can throw NoSuchElementException). orElse(T) / orElseGet(Supplier): Provides
 * defaults. ifPresent(Consumer): Executes action if value exists. map() /
 * filter(): Allows functional manipulation. When to use? Primarily for method
 * return types to indicate potential absence. It is not recommended for field
 * types or method arguments
 */
