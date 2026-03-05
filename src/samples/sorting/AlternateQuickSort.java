package samples.sorting;

public class AlternateQuickSort {
	/*
	 * function that consider last element as pivot, place the pivot at its exact
	 * position, and place smaller elements to left of pivot and greater elements to
	 * right of pivot.
	 */
	int partition(int a[], int start, int end) {
		int pivot = a[end]; // pivot element
		int i = (start - 1); // pointer initiated before array on 1st pass

		for (int j = start; j <= end - 1; j++) {
			// If current element is smaller than the pivot
			if (a[j] < pivot) {
				i++; // increment index of smaller element
				swap(a, i, j);
			}
		}
		swap(a, i + 1, end);
		return (i + 1);
	}

	/* function to implement quick sort */
	void quick(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */
	{
		if (end <= start)
			return;
		int pivot = partition(a, start, end); // p is partitioning index
		quick(a, start, pivot - 1);
		quick(a, pivot + 1, end);

	}

	/* function to print an array */
	void printArr(int a[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 5, 3, 7, 9, 32, 12, 43, 56, 42, 12 };
		int n = a.length;
		System.out.println("\nBefore sorting array elements are - ");
		AlternateQuickSort q1 = new AlternateQuickSort();
		q1.printArr(a, n);
		q1.quick(a, 0, n - 1);
		System.out.println("\nAfter sorting array elements are - ");
		q1.printArr(a, n);
		System.out.println();
	}

}
