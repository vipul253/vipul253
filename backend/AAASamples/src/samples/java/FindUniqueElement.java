package samples.java;

public class FindUniqueElement {
	// There is array with every element repeated twice except one.
	// WAP to Find that element
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 3, 1 }; // Example array

		// Find the unique element
		int uniqueElement = findUniqueElement(arr);

		// Print the result
		System.out.println("The unique element in the array is: " + uniqueElement);
	}

	// Method to find the unique element in the array
	//	you can find a unique element in an array by XORing all elements, but only if every other element appears exactly twice. 
	//
	//	How it works:
	//	XOR properties:
	//	a ^ a = 0 (any number XORed with itself is 0)
	//	a ^ 0 = a (any number XORed with 0 is itself)
	//	XOR is commutative and associative, so order doesn't matter. 
	//	When you XOR all elements in an array where one number appears once and all others appear twice:
	//
	//	All paired numbers cancel out to 0.
	//	Only the unique number remains.
	private static int findUniqueElement(int[] arr) {
		int result = 0;

		// XOR all elements in the array
		for (int num : arr) {
			result ^= num;
		}

		return result;
	}
}
