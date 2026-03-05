package samples.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KclosestToOrigin {

	/*
	 * Given an array of points where points[i] = [xi, yi] represents a point on the
	 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
	 * 
	 * The distance between two points on the X-Y plane is the Euclidean distance
	 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
	 * 
	 * You may return the answer in any order. The answer is guaranteed to be unique
	 * (except for the order that it is in).
	 */

	public static int squaredDis(int[] p) {
		return p[0] * p[0] + p[1] * p[1];
	}

	// only array sort approach
	public static int[][] kClosest(int[][] points, int k) {

		// sort by sending comparator dist square
		Arrays.sort(points, (a, b) -> squaredDis(a) - squaredDis(b));
		return Arrays.copyOfRange(points, 0, k);
	}

	// heap Approach -> proTip heap is a PriorityQueue which is made by an array as
	// a physical Data Structure.
	public static int[][] kClosestByHeap(int[][] points, int k) {
		//remember its b - a not a -b
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> squaredDis(b) - squaredDis(a));

		for (int[] p : points) {
			heap.offer(p);
			if (heap.size() > k)
				heap.poll();
		}

		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++)
			res[i] = heap.poll();
		return res;
	}
}
