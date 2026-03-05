package samples.searching;

public class BinarySearch {
	// binary search = Search algorithm that finds the position
	// of a target value within a sorted array.
	// Half of the array is eliminated during each "step"
	public static void main(String[] args) {

		int array[] = new int[100000];
		int target = 123456;

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		// int index = Arrays.binarySearch(array, target); //inbuilt BinarySearch
		// int index = binarySearch(array, target);
		int index = binarySearch(array, target, 0, array.length - 1);
		if (index == -1) {
			System.out.println(target + " not found");
		} else {
			System.out.println("Element found at: " + index);
		}

	}

	// iterative method - better because no recursive stack overflow
	public static int binarySearch(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int middle = start + (end - start) / 2;
			System.out.println("middle: " + arr[middle]);
			if (arr[middle] < target)
				start = middle + 1;
			else if (arr[middle] > target)
				end = middle - 1;
			else
				return middle; // target found
		}
		return -1;
	}

	// recursive method
	public static int binarySearch(int[] arr, int target, int start, int end) {
		if (start <= end) {

			int middle = start + (end - start) / 2;
			System.out.println("middle: " + arr[middle]);
			if (arr[middle] < target)
				return binarySearch(arr, target, middle + 1, end);
			else if (arr[middle] > target)
				return binarySearch(arr, target, start, middle - 1);
			else
				return middle; // target found
		}
		return -1;
	}

}
