package samples.heap;

public class MinHeap {
	private int[] heap;
	private int size = 0;

	public MinHeap(int[] arr) {
		this.heap = new int[arr.length];
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

	private int getParentId(int childId) {
		return (childId - 1) / 2;
	}

	// checkers
	public boolean hasLeftChild(int parentId) {
		return getLeftChildId(parentId) < size;
	}

	public boolean hasRightChild(int parentId) {
		return getRightChildId(parentId) < size;
	}

	public boolean hasParent(int childId) {
		return getParentId(childId) >= 0;
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

	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return this.heap[0];
	}

	public int extractMin() {
		if (size == 0)
			throw new IllegalStateException("Heap is empty");
		int min = this.heap[0];
		this.heap[0] = this.heap[--size];
		heapifyDown(0);
		return min;
	}

	// Heapify down from a given index
	private void heapifyDown(int i) {
		if (isLeaf(i))
			return;

		int left = getLeftChildId(i);
		int right = getRightChildId(i);
		int smallest = i;

		if (left < size && heap[left] < heap[smallest])
			smallest = left;
		if (right < size && heap[right] < heap[smallest])
			smallest = right;

		if (smallest != i) {
			swap(i, smallest);
			heapifyDown(smallest);
		}
	}

	// Build heap from an array
	private void buildHeap(int[] arr) {
		System.arraycopy(arr, 0, heap, 0, size);
		// size/2 -1 is selecting parent of last leaf
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapifyDown(i);
		}
	}
}
