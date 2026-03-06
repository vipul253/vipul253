package samples.threading;

//extend or implement anyone will do
public class NewThreadSample extends Thread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				Thread.yield();// hints JVM to allows other threads to run
				System.out.println("Priority:" + Thread.currentThread().getPriority());
				// + " 1 is LOW, 5 is MID, 10 is HIGH");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// user threads, jvm waits for these even after main ends
		Thread t1 = new NewThreadSample();
		// DAEMON marked true so JVM will not wait after main ends
		t1.setDaemon(true);
		t1.start();
		// main waited for t1 even if it was daemon because of join
		t1.join();
		
		// interrupts whatever this thread is doing,
		// if sleeping then sleep throws interruped exception
		// t1.interrupt();
		// makes the calling thread wait for t1, here main is waiting
		// t1.join();
		// System.out.println(Thread.currentThread().getName());

		// to make a thread class extend Thread or implement Runnable
		// when extends thread class we can use start()
		// Thread samplethread = new NewThreadSample();// NEW thread created, not started
		// samplethread.start();
		// ^RUNNABLE state waiting for CPU time or running already
		// BLOCKED / WAITING / TIMED_WAITING / TERMINATED

		// when implements runnable pass that class to thread class and then call
		// start()
		// Thread t1 = new Thread(samplethread);
		// System.out.println(t1.getState());
		// t1.start();
		// System.out.println(t1.getState());

		// as Runnable is functional interface we can pas a lambda exp to thread class
		// without creating new class to extend Thread or implement Runnable
		//Thread t2 = new Thread(() -> {
//			for (int i = 0; i < 10; i++) {
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.print(" WorldLambda");
//			}
		//});
		//System.out.println(t1.getState());
		//t2.start();
		//System.out.println(t2.getState());
		//for (int i = 0; i < 10; i++) {
//			Thread.sleep(200);
//			System.out.println("Hello");
		//}
		//System.out.println(t2.getState());
	}

}





