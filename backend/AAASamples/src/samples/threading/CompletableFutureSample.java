package samples.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSample {
	public static void main(String[] args) {
		
		//CompletableFuture has daemon pool by default so JVM shuts it after main ends
		//so we provide a Executor pool
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			// Simulate a long-running operation
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "Result from async operation";
		}, executor);
		executor.shutdown();
		future.thenAccept(result -> System.out.println("Received: " + result));
		System.out.println("Main thread continues without waiting.");
	}
}
