package samples.interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingBlockingQueue {

	// given 2 thread entity consumer and producer handle there communication
	// such that they dont get stuck and are able to read and write to shared
	// resource. using blocking queue so no need to write wait notify
	public static void main(String[] args) {

		int n = 11;// take from console when asked

		//use dedicated method put and take to of queue to synch wait notify
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		
		Thread producerThread = new Thread(() -> {
			for (int i = 1; i < n; i++) {
				try {
					//shared.putInResource(i);
					//queue.add(" product " + i); if full then throws exception
					queue.put(" product " + i); //if full then waits
					System.out.println("Producer produced " + i);
					Thread.sleep(100); // this allows time consumer to read from resource
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(() -> {
			for (int i = 1; i < n; i++) {
				try {
					//shared.getFromResource();
					//queue.poll(); // returns null if queue empty
					String msg = queue.take();//will wait and not take null
					System.out.println("Consumed " + msg);
					Thread.sleep(50); // this allows time produce to add in resource
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producerThread.start();
		consumerThread.start();
	}
}
