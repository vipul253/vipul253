package samples.java;

public class MaxSumHourGlass {

	/*
	a b c
	  d
	e f g
	hourglass 

	2D Arry hourglasses
	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0

	there are many such hour glasses in the array above. 
	The three leftmost hour glasses are the following:

	1 1 1     1 1 0     1 0 0
	  1         0         0
	1 1 1     1 1 0     1 0 0 
	*/
	//find max sum from all possible hourglasses -->
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		// sum of all 1s is 7
		int[][] arr = {
			{1, 1, 1, 0, 0, 0},
			{0, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}
		};
//		Reading 6x6 array
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 6; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
		int maxSum = Integer.MIN_VALUE; // To handle negative numbers too

		// Loop through possible hour glass centers
		for (int i = 1; i < 5; i++) { //row 1 to row n-2
			for (int j = 1; j < 5; j++) { //col 1 to n-2
				int sum = arr[i][j] // middle
						+ arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] // top
						+ arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]; // bottom

				maxSum = Math.max(maxSum, sum);
			}
		}

		System.out.println(maxSum);
	}
}
