package samples.interview;

public class ChildTemp extends ParentTemp {

	ChildTemp() {
		super("Constructor");
		System.out.println("Child Class Default Constructor");
	}

	ChildTemp(String s) {
		// super(); constructor call must be the 1st statement;
		// this(); constructor call must be the 1st statement;
		// if i call anyone it will make the other 2nd so will not work;
		System.out.println("Child Class Param Constructor " + s);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ChildTemp obj = new ChildTemp();
	}
}
/*
 * The Java compiler automatically provides a default no-argument constructor
 * if, and only if, you do not declare any other constructors in your class. If
 * you define a parameterized constructor (one that takes arguments), the
 * compiler will not automatically generate the no-argument constructor, which
 * is why you might need to define it explicitly
 * 
 * Inheritance: When a subclass is instantiated, its constructor implicitly
 * calls the no-argument constructor of its superclass (if it doesn't explicitly
 * call another super() constructor). If the superclass only has a parameterized
 * constructor and no no-argument constructor is defined, the subclass will fail
 * to compile.
 */