package samples.java;

import java.util.Scanner;

public class GeneratePrimes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the limit N:");
		int N = scanner.nextInt();
		scanner.close();

		System.out.println("Prime numbers up to " + N + " are:");
		printPrimesTillN(N);
	}

	public static void printPrimesTillN(int N) {
		// Start loop from 2, as 1 is not a prime number
		for (int i = 2; i <= N; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
		System.out.println();
	}

	/**
	 * Checks if a given number is prime. Optimizes the check by iterating only up
	 * to the square root of the number.
	 */
	private static boolean isPrime(int number) {
		// Numbers less than 2 are not prime
		if (number <= 1) {
			return false;
		}
		int sqrt = (int) Math.sqrt(number);
		// Check for factors from 2 up to the square root of the number
		for (int i = 2; i <= sqrt; i++) {
			if (number % i == 0) {
				return false; // Found a divisor, so it's not prime
			}
		}
		return true; // No divisors found, so it's prime
	}
}
