package samples.sorting;

import samples.heap.MaxHeap;
import samples.heap.MinHeap;
import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 45, 5, 8, 9, 13, 12, 16};
		// int[] arr= new int[17]; // Define array size
		// Random rand = new Random();
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = rand.nextInt(10000); // Random int (any value)
		// }

		System.out.println(Arrays.toString(arr));
		MinHeap h = new MinHeap(arr);
		for(int i=0;i<arr.length;i++) {
			arr[i] = h.extractMin();
		}
		System.out.println(Arrays.toString(arr));
		
		MaxHeap mH = new MaxHeap(arr);
		mH.sortHeap();
		System.out.println(Arrays.toString(arr));
	}
}
