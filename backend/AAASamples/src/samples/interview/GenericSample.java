package samples.interview;

public class GenericSample {

	public static void main(String[] args) {
		// Create a Box specifically for Strings
		Box<String> strBox = new Box<>();
		strBox.set("Java");
		String val = strBox.get();
		System.out.println(val);

		// Create a Box specifically for Integers
		Box<Integer> intBox = new Box<>();
		intBox.set(123);
		int b = intBox.get();
		System.out.println(b);
	}
}

class Box<T> {
	private T content;

	public void set(T content) {
		this.content = content;
	}

	public T get() {
		return content;
	}
}