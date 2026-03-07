package samples.interview;

import java.util.ArrayList;

public class ProducerConsumerProblem {

	//given 2 thread entity consumer and producer handle there communication 
	//such that they dont get stuck and are able to read and write to shared resource.
	public static void main(String[] args) {

		int n = 11;// take from console when asked
		SharedResourceSample shared = new SharedResourceSample(4);

		Thread producerThread = new Thread(() -> {
			for (int i = 1; i < n; i++) {
				try {
					shared.putInResource(i);
					Thread.sleep(100); // this allows time consumer to read from resource
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(() -> {
			for (int i = 1; i < n; i++) {
				try {
					shared.getFromResource();
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

class SharedResourceSample {

	int capacity;
	// here array is the shared buffer of limited size
	ArrayList<String> resource = new ArrayList<>(capacity);

	public SharedResourceSample(int capacity) {
		this.capacity = capacity;
	}

	public synchronized void putInResource(int i) throws InterruptedException {
		while (capacity == resource.size()) {
			wait(); //waiting till consumer consumes from resource
		}
		resource.add(" product " + i);
		System.out.println("Producer produced " + i);
		notifyAll();
	}

	public synchronized void getFromResource() throws InterruptedException {
		while (resource.size() == 0) {
			wait(); // waiting till producerThread adds something to resource
		}
		String msg = resource.removeFirst();
		System.out.println("Consumed " + msg);
		notifyAll();
	}
}
