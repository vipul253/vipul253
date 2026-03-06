package samples.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 8, 5, 2, 6, 9, 1 };
		// int[] arr= new int[17]; // Define array size
		// Random rand = new Random();
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = rand.nextInt(10000); // Random int (any value)
		// }

		System.out.println(java.util.Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(java.util.Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr) {
		divide(arr, new int[arr.length], 0, arr.length - 1); // with temp array buffer
	}

	public static void merge(int[] arr, int[] buffer, int start, int mid, int end) {
		// Copy data to buffer
		for (int i = start; i <= end; i++) {
			buffer[i] = arr[i];
		}
		// Merge back into array
		int i = start, j = mid + 1, k = start;
		while (i <= mid && j <= end) {
			if (buffer[i] <= buffer[j]) {
				arr[k++] = buffer[i++];
			} else {
				arr[k++] = buffer[j++];
			}
		}
		while (i <= mid)
			arr[k++] = buffer[i++];
	}

	public static void divide(int[] arr, int[] buffer, int start, int end) {
		if (start >= end)
			return;
		int mid = start + (end - start) / 2; // (start + end)/2 can overflow
		divide(arr, buffer, start, mid);
		divide(arr, buffer, mid + 1, end);
		merge(arr, buffer, start, mid, end);
	}

}
