package samples.general;

import java.util.ArrayList;
import java.util.List;

public class ShootingRange {

	/**
	 * You are at a shooting range with N targets labeled 1 to N from left to right.
	 * In each round, starting from the first target and moving from left to right,
	 * you hit (and hence remove) every alternate target. Each hit on a target
	 * labeled i gives you i points. This process repeats until only one target
	 * remains. Calculate the total score obtained (sum of points for the targets
	 * hit) throughout the process, and write the code in Java using an optimized
	 * approach.
	 * 
	 * To calculate the total points from a shooting range with targets ( labeled 1
	 * to n ), where every alternate target is removed starting from the first until
	 * one remains, use a simulation approach with an ArrayList. The total score is
	 * the sum of all removed target labels.
	 */
	public static long calculateScore(int n) {
		List<Integer> targets = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			targets.add(i);
		}
		long totalPoints = 0;

		while (targets.size() > 1) {
			List<Integer> nextRound = new ArrayList<>();
			// If starting from left, remove 1st, 3rd, 5th... (indices 0, 2, 4...)
			// This logic needs to align with alternating left-to-right/right-to-left
			// but the basic problem states "every alternate target"
			for (int i = 0; i < targets.size(); i++) {
				if (i % 2 == 0) {
					totalPoints += targets.get(i);
				} else {
					nextRound.add(targets.get(i));
				}
			}
			targets = nextRound;
			// The simulation continues until only one target remains
		}
		return totalPoints;
	}

	public static void main(String[] args) {
		int n = 7; // Example
		System.out.println("Total Points: " + calculateScore(n));
		System.out.println("Total Points: " + calculateScoreOptimal(n));
	}

	/*
	 * optimal Math based solution Step 1 Calculate the sum of all labels from 1 to
	 * N using the formula: S = 2 N(N+1) ​
	 * 
	 * Step 2 Compute the final survivor label. This is the largest power of 2 less
	 * than or equal to N. In Java, you can obtain this by using:
	 * 
	 * int lastSurvivor = Integer.highestOneBit(N); Step 3 Subtract the survivor's
	 * label from the total sum to obtain the score. Score=S−lastSurvivor
	 * 
	 * 1 2 3 4 5 6 7 8 9 10 list 1 3 5 7 9 sum
	 * 
	 * 2 4 6 8 10 list 2 6 10 sum
	 * 
	 * 4 8 list 4 sum
	 * 
	 * 8 last survivor
	 */

	public static long calculateScoreOptimal(int n) {
		// Sum of all target labels
		int sum = n * (n + 1) / 2;
		// Find the largest power of 2 less than or equal to N
		int lastSurvivor = Integer.highestOneBit(n);
		// The score is the sum minus the label of the last remaining target
		return sum - lastSurvivor;
	}
}
