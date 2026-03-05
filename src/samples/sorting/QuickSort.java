package samples.sorting;
import java.util.Arrays;
public class QuickSort {
	// quick sort = moves smaller elements to left of a pivot.
	// recursively divide array in 2 partitions
	// run-time complexity = Best case O(n log(n))
	// Average case O(n log(n))
	// Worst case O(n^2) if already sorted
	// space complexity = O(log(n)) due to recursion

	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 5, 3, 7, 9, 32, 12, 43, 56, 42 };
		// int[] arr = { 3, 3, 2, 1, 4, 1, 5 };
		System.out.println(Arrays.toString(arr));
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void quicksort(int[] a, int start, int end) {
		if (end <= start)
			return;

		int lt = start, gt = end;
		int pivot = a[start]; // 1st element pivot
		int i = start + 1;

		while (i <= gt) {
			int cmp = Integer.compare(a[i], pivot);
			if (cmp < 0) {
				swap(a, lt++, i++);
			} else if (cmp > 0) {
				swap(a, i, gt--);
			} else {
				i++;
			}
		} // can place partitioning separately
			// Now a[lo..lt-1] < pivot = a[lt..gt] < a[gt+1..hi]
		quicksort(a, start, lt - 1);
		quicksort(a, gt + 1, end);
	}
}
