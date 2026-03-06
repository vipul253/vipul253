package samples.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchSample {

	//if there are numerous tasks to be done by Executors before doing something, 
	//we need to write future.get() again and again for all task which return a future,
	//instead we make a CountDownLatch class and send it the number of tasks to await them altogether.
	public static void main(String[] args) throws InterruptedException {
		int n = 3; //no of tasks;
		ExecutorService executorService = Executors.newFixedThreadPool(n);
		CountDownLatch latch = new CountDownLatch(n);
		executorService.submit(new DependentService(latch));
		executorService.submit(new DependentService(latch));
		executorService.submit(new DependentService(latch));
		latch.await();
		System.out.println("Main");
		executorService.shutdown();
	}
}

class DependentService implements Callable<String> {
	private final CountDownLatch latch;

	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}

	//dummy task callable's call
	public String call() throws Exception {
		try {
			System.out.println(Thread.currentThread().getName() + " service started.");
			Thread.sleep(2000);
		} finally {
			latch.countDown();//reduce count
		}
		return "ok";
	}
}
