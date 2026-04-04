package samples.interview;

import java.util.Arrays;

public class FindPlatformCount {

	public static int findPlatform(int[] arr, int[] dep) {
		// Assuming time is in HHMM format and max 24 hours.
		// Using 2400 for 24-hour clock + margin
		int[] platformTimeline = new int[2405];//2400 hours

		for (int i = 0; i < arr.length; i++) {
			platformTimeline[arr[i]]++;
			platformTimeline[dep[i] + 1]--;// or just dep[i] for instant departure
		}

		int maxPlatforms = 0;
		int currentPlatforms = 0;
		for (int i = 0; i < 2405; i++) {
			currentPlatforms += platformTimeline[i];
			maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
		}
		return maxPlatforms;
	}

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println("Minimum Platforms Required: " + findPlatform(arr, dep)); // Output: 3
		int n = arr.length;
        System.out.println("Minimum Platforms Required: " + findMinimumPlatforms(arr, dep, n));
	}

	// general approach by sorting
	public static int findMinimumPlatforms(int[] arr, int[] dep, int n) {
		// 1. Sort arrival and departure times
		Arrays.sort(arr);
		Arrays.sort(dep);

		int platformsNeeded = 1;
		int maxPlatforms = 1;
		int i = 1, j = 0;//check this, check arrival from 1

		// 2. Use two pointers to compare arrival and departure
		while (i < n && j < n) {
			// If next train arrives before current one departs,
			// we need an extra platform
			if (arr[i] <= dep[j]) {
				platformsNeeded++;
				i++;
			}
			// If a train departs, one platform becomes free
			else {
				platformsNeeded--;
				j++;
			}

			// Update the maximum platforms needed so far
			if (platformsNeeded > maxPlatforms) {
				maxPlatforms = platformsNeeded;
			}
		}
		return maxPlatforms;
	}
}
