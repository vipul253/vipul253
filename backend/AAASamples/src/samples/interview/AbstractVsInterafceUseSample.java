package samples.interview;

public class AbstractVsInterafceUseSample {

	/*
	 * Defining APIs: Interfaces are often used to define APIs in frameworks, such
	 * as Java's Collection Framework. - Multiple Inheritance: Java doesn't support
	 * multiple inheritance for classes, but a class can implement multiple
	 * interfaces, allowing for multiple inheritance of behaviors
	 * 
	 * In object-oriented programming, especially in Java, it’s important to know
	 * the difference between an abstract class vs interface. Both help you build
	 * classes, but they are used in different ways. Abstract classes let you share
	 * common code between related classes. Interfaces define rules that any class
	 * can follow, making your code more flexible and easier to change
	 */
	public static void main(String[] args) {

		// Animal myAnimal = new Animal("Generic"); // Error: Cannot instantiate
		Pet myDog = new Dog("Buddy");// 
		myDog.makeSound(); // Buddy says: Woof! Woof!
		myDog.sleep(); // Buddy is sleeping: Zzz

		Circle c = new Circle();
		c.draw();
		c.fill();
	}
}

//Interface
@FunctionalInterface
interface Drawable {
	void draw(); // Implicitly public and abstract
	//void draw2(); // checked error for @FunctionalInterface
}

//Another Interface
interface Colorable {
	void fill();
}

//Implementation Class
class Circle implements Drawable, Colorable {
	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}

	@Override
	public void fill() {
		System.out.println("Filling Circle with Color");
	}
}

//Abstract Class
abstract class Pet {
	String name;

	// Constructor
	public Pet(String name) {
		this.name = name;
	}

	// Abstract method (no body, must be implemented by subclass)
	abstract void makeSound();

	// Concrete method (shared behavior)
	void sleep() {
		System.out.println(name + " is sleeping: Zzz");
	}
}

//Concrete subclass
class Dog extends Pet {
	public Dog(String name) {
		super(name);
	}

	@Override
	void makeSound() {
		System.out.println(name + " says: Woof! Woof!");
	}
}
