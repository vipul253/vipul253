package samples.sorting;

public class InsertionSort {
	//Insertion sort = after comparing elements to the left,
	//shift elements to the right to make room to insert a value
	//Quadratic time O(n^2)
	//small data set = decent
	//large data set = BAD
	//Less steps than Bubble sort
	//Best case is O(n) compared to Selection sort O(n^2)
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 45, 5, 8, 9, 13, 12, 17, 14, 15 };
		// int[] arr= new int[17]; // Define array size
		// Random rand = new Random();
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = rand.nextInt(10000); // Random int (any value)
		// }

		System.out.println(java.util.Arrays.toString(arr));
		insertionSort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
