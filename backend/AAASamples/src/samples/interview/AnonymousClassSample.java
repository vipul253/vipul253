package samples.interview;

import java.util.ArrayList;
import java.util.List;

//Normal class
class Animal {
	public void makeSound() {
		System.out.println("Animal sound");
	}
}

//Interface
interface Greeting {
	void sayHello();
}

public class AnonymousClassSample {

	/*
	 * Anonymous classes are best when the necessary behavior only needs to be
	 * defined once in the outer class, or preferably only once in the whole project
	 * It is an inner class without a name and for which only a single object is
	 * created. An anonymous inner class can be useful when making an instance of an
	 * object with certain "extras" such as overriding methods of a class or
	 * interface, without having to actually subclass a class.
	 * 
	 * Tip: Anonymous inner classes are useful in writing implementation classes for
	 * listener interfaces in graphics programming.
	 * 
	 * Anonymous classes cannot have any static members except for those that are
	 * constant.
	 */
	public static void main(String[] args) {

		// Anonymous class that overrides makeSound()
		Animal myAnimal = new Animal() {
			public void makeSound() {
				System.out.println("Woof woof");
			}
		}; // semicolon is required to end the line of code that creates anonymous object
		myAnimal.makeSound();

		// Anonymous class that implements Greeting
		Greeting greet = new Greeting() {
			public void sayHello() {
				System.out.println("Hello, World!");
			}
		};
		greet.sayHello();

		List<Runnable> actions = new ArrayList<Runnable>();
		actions.add(new Runnable() {
			@Override
			public void run() {
				System.out.println("inline anonymous runnable implementation inside list");
			}
		});
		
		Thread t1 = new Thread(actions.get(0));
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}