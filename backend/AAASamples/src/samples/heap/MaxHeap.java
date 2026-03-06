package samples.heap;

public class MaxHeap {

	private int[] heap;
	private int size = 0;

	public MaxHeap(int[] arr) {
		this.heap = arr;
		this.size = arr.length;
		this.buildHeap(arr);
	}

	// getters to get index
	private int getLeftChildId(int parentId) {
		return (parentId * 2) + 1;
	}

	private int getRightChildId(int parentId) {
		return (parentId * 2) + 2;
	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	// Check if a node is a leaf
	private boolean isLeaf(int i) {
		return i >= size / 2 && i < size;
	}

	// Heapify down from a given index
	private void heapifyDown(int i) {
		if (isLeaf(i))
			return;

		int left = getLeftChildId(i);
		int right = getRightChildId(i);
		int largest = i;

		if (left < size && heap[left] > heap[largest])
			largest = left;
		if (right < size && heap[right] > heap[largest])
			largest = right;

		if (largest != i) {
			swap(i, largest);
			heapifyDown(largest);
		}
	}

	// Build heap from an array
	private void buildHeap(int[] arr) {
		// size/2 -1 is selecting parent of last leaf
		for (int i = size / 2 - 1; i >= 0; i--) {  
			heapifyDown(i);
		}
	}
	
	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return this.heap[0];
	}

	public int extractMax() {
		if (size == 0)
			throw new IllegalStateException("Heap is empty");
		int min = this.heap[0];
		this.heap[0] = this.heap[--size];
		heapifyDown(0);
		return min;
	}

	public void sortHeap() {
		for (int i = heap.length - 1; i >= 0; i--) {
			int max = extractMax();
			heap[i] = max;
		}
	}
}
