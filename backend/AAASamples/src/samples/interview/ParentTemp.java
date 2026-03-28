package samples.interview;

public class ParentTemp {

	ParentTemp() {
		this("Constructor");
		System.out.println("Parent class Default Constructor");
	}

	ParentTemp(String s) {
		System.out.println("Parent Class Param  " + s);
	}
}
/*
 * The Java compiler automatically provides a default no-argument constructor
 * if, and only if, you do not declare any other constructors in your class. If
 * you define a parameterized constructor (one that takes arguments), the
 * compiler will not automatically generate the no-argument constructor, which
 * is why you might need to define it explicitly
 */