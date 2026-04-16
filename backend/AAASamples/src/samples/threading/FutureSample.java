package samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// Submitting a task to get a result
		Future<String> future1 = executor.submit(() -> {
			Thread.sleep(2000);
			return "Result from blocking async operation";
		});
		executor.shutdown();
		
		// BLOCKING: The main thread stops here until the result is ready
		String result;
		result = future1.get();
		System.out.println(result);
		System.out.println("Main thread after waiting.");
	}
}
