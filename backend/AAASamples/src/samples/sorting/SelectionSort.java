package samples.sorting;

import java.util.Arrays;

public class SelectionSort {
	// selection sort = search through an array and keep track of the minimum value
	// during each iteration. At the end of each iteration, we swap variables.
	// Quadratic time O(n^2)
	// small data set = okay
	// large data set = BAD
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 45, 5, 8, 9, 13, 12, 16, 14, 3 };
		// int[] arr= new int[17]; // Define array size
		// Random rand = new Random();
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = rand.nextInt(10000); // Random int (any value)
		// }

		System.out.println(Arrays.toString(arr));
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 2; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}
