package samples.threading;

public class ThreadingTest {

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				c.incrementWithCustomLock();
			}
		};

		Thread t1 = new Thread(task, "user1");
		Thread t2 = new Thread(task, "user2");
		t1.start();
		t2.start();

		// making main wait for threads
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}

	}
}
