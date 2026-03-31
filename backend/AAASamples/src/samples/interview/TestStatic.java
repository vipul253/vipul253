package samples.interview;

public class TestStatic {
	public static void main(String[] args) {
		Parent p = new Child();
		// Calls Parent's static method because the reference type is Parent
		p.display(); // Output: Static method in Parent

		Child c = new Child();
		// Calls Child's static method because the reference type is Child
		c.display(); // Output: Static method in Child
	}
}

class Parent {
	static void display() {
		System.out.println("Static method in Parent");
	}
}

class Child extends Parent {
	// This hides the Parent's display() method
	static void display() {
		System.out.println("Static method in Child");
	}
}
