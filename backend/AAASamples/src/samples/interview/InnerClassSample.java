package samples.interview;

public class InnerClassSample {

	/*
	 * used to logically group classes that are only used in one place, increase
	 * encapsulation, and can lead to more readable and maintainable code.
	 * 
	 * Encapsulation: Inner classes can access private members of the outer class,
	 * providing better encapsulation.
	 * 
	 * Code Organization: Logically groups classes that belong together, making code
	 * more readable.
	 * 
	 * Access to Outer Class: Inner class instances have a reference to the outer
	 * class instance.
	 * 
	 * Name space Management: Helps avoid naming conflicts by nesting related
	 * classes.
	 */
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();// inner syntax
		inner.display();
		OuterClass.StaticInnerClass.display();// inner static call syntax
	}
}

class OuterClass {

	private int y = 100;
	private static int x = 10;

	class InnerClass {
		void display() {
			System.out.println("Hello from Inner Class! " + (y + x));
		}
	}

	static class StaticInnerClass {
		static void display() {
			System.out.println("Hello from Static Inner Class! " + x);
		}
	}
}
