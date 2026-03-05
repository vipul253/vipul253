package samples.sorting;

public class BubbleSort {
	// bubble sort = pairs of adjacent elements are compared, and the elements
	// swapped if they are not in order.

	// Quadratic time O(n^2)
	// small data set = okay-ish
	// large data set = BAD (plz don't)
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 45, 5, 8, 9, 13, 12, 16, 14, 15 };
		// int[] arr= new int[17]; // Define array size
		// Random rand = new Random();
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = rand.nextInt(10000); // Random int (any value)
		// }

		System.out.println(java.util.Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean isSwap = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwap=true;
				}
			}
			if(!isSwap) return;
		}
	}
}
