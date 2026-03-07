package samples.interview;

public class TryCatchFinally {

	// state whether finally block will execute
	public static void main(String[] args) {

//		Only 2 cases can make finally stop 
//		1. System.exit(0); 
//		2. System has been crashed
		try {
			System.out.println("try");
			// intentional divide by 0
			System.out.println(5 / 0);
		} catch (ArithmeticException e) {
			System.out.println("catched");
			// System.exit(0);
			// only by adding this can we stop finally from running
			return;
		} finally {
			System.out.println("finally");
		}

	}
}
