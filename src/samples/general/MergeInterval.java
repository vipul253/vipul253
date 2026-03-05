package samples.general;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeInterval {
	/*
	 * Given an array of intervals where intervals[i] = [starti, endi], merge all
	 * overlapping intervals, and return an array of the non-overlapping intervals
	 * that cover all the intervals in the input.
	 * 
	 */

	public static int[][] merge(int[][] intervals) {
		if (intervals.length < 2) {
			return intervals;
		}

		Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
		List<int[]> res = new ArrayList<>();

		int[] baseInterval = intervals[0];
		res.add(baseInterval);

		for (int[] interval : intervals) {
			if (interval[0] <= baseInterval[1]) {
				// lower bound of newInterval <= baseInterval upper bound
				// update upper bound to max of both overlapping intervals
				baseInterval[1] = Math.max(baseInterval[1], interval[1]);
			} else {
				// no overlap so make new interval
				baseInterval = interval;
				res.add(baseInterval);
			}
		}
		return res.toArray(new int[res.size()][]); // casting to required output type
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		// int[][] expectedOutput = {{1, 6}, {8, 10}, {15, 18}};
		intervals = merge(intervals);
		for (int[] interval : intervals)
			System.out.print(Arrays.toString(interval));
	}
}
