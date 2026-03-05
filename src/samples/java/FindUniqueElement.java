package samples.java;

public class FindUniqueElement {
	//There is array with every element repeated twice except one. 
	//WAP to Find that element
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 2, 3, 1 }; // Example array

		// Find the unique element
		int uniqueElement = findUniqueElement(arr);

		// Print the result
		System.out.println("The unique element in the array is: " + uniqueElement);
	}

	// Method to find the unique element in the array
	private static int findUniqueElement(int[] arr) {
		int result = 0;

		// XOR all elements in the array
		for (int num : arr) {
			result ^= num;
		}

		return result;
	}
}
