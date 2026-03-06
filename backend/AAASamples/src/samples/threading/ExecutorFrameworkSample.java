package samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameworkSample {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 1; i < 10; i++) {
			int finalI = i;
			executor.submit(() -> {
				long result = factorial(finalI);
				System.out.println(result);
			});

		}
		executor.shutdown(); 
		// shutdown given, now main thread won't wait
		// so below code to make main wait.
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Total time " + (System.currentTimeMillis() - startTime));
	}

	//simulating heavy task
	private static long factorial(int n) {
		try {
			Thread.sleep(999);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
