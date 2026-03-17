package samples.searching;

public class KokoEatsBanana {
	/*
	 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has
	 * piles[i] bananas. The guards have gone and will come back in h hours.
	 * 
	 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
	 * chooses some pile of bananas and eats k bananas from that pile. If the pile
	 * has less than k bananas, she eats all of them instead and will not eat any
	 * more bananas during this hour.
	 * 
	 * Koko likes to eat slowly but still wants to finish eating all the bananas
	 * before the guards return.
	 * 
	 * Return the minimum integer k such that she can eat all the bananas within h
	 * hours.
	 * 
	 * Example 1: Input: piles = [3,6,7,11], h = 8 Output: 4
	 */
	// brute force TLE
	public static int minEatingSpeed(int[] piles, int h) {
		int ans = 1;
		int totalhourTaken = Integer.MAX_VALUE;
		// to understand binary search approach take a for loop from 1 to max number in
		// array, so that will be the range Binary Search will search on
		while (totalhourTaken > h) {
			int hourTaken = 0;
			for (int j = 0; j < piles.length; j++) {
				hourTaken = hourTaken + (int) Math.ceil((double) piles[j] / ans);
				if (hourTaken > h) {
					ans++;
					break;
				}
			}
			totalhourTaken = hourTaken;
		}
		return ans;
	}

	// using binary search
	public static int minEatingSpeedBS(int[] piles, int h) {
		int mid;
		int lo = 1;
		int hi = 0;
		for (int p : piles)
			hi = Math.max(hi, p);
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			long hoursTaken = 0;
			for (int i : piles)
				hoursTaken = hoursTaken + (int) Math.ceil((double) i / mid);// OR (i+mid-1)/mid

			if (hoursTaken <= h) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	// LeetCode optimized
	public static long tot(int[] piles, int n, int k) {
		long h = 0;
		for (int i = 0; i < n; i++) {
			h += (long) ((piles[i] + k - 1) / k);
		}
		return h;
	}

	public static int minEatingSpeedOP(int[] piles, int h) {
		int r = -1;
		for (int i = 0; i < piles.length; i++)
			r = Math.max(r, piles[i]);
		int l = 1;
		while (l <= r) {
			int m = (l + r) / 2;
			long ht = tot(piles, piles.length, m);
			if (ht <= h)
				r = m - 1;
			else
				l = m + 1;
		}
		return l;
	}

	public static void main(String[] args) {
		// int[] piles = { 30, 11, 23, 4, 20 };
		// int[] piles = { 3, 6, 7, 11 };
		int[] piles = { 805306368, 805306368, 805306368 };
		int h = 1000000000;
		System.out.println(minEatingSpeed(piles, h));
		System.out.println(minEatingSpeedBS(piles, h));
		System.out.println(minEatingSpeedOP(piles, h));
	}
}
