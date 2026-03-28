package samples.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantSequencePrinter {
	private int number = 1;
	private final int MAX = 10;
	private final Lock lock = new ReentrantLock();
	private final Condition c1 = lock.newCondition();
	private final Condition c2 = lock.newCondition();
	private final Condition c3 = lock.newCondition();

	public void printNumbers(int id) {
		while (true) {
			lock.lock();
			try {
				// If we've passed MAX, wake others and exit
				if (number > MAX) {
					signalAll();
					return;
				}
				// Wait if it's not this thread's turn
				while (getTargetThread() != id) {
					getCondition(id).await();
					if (number > MAX)
						return; // Re-check after waking up
				}
				if (number <= MAX) {
					System.out.println("Thread " + id + ": " + number);
					number++;
				}
				signalAll(); // Wake others to check the new 'number'
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				lock.unlock();
			}
		}
	}

	private int getTargetThread() {
		return (number % 3 == 0) ? 3 : (number % 3);
	}

	private Condition getCondition(int id) {
		return (id == 1) ? c1 : (id == 2) ? c2 : c3;
	}

	private void signalAll() {
		c1.signal();
		c2.signal();
		c3.signal();
	}

	public static void main(String[] args) {
		ReentrantSequencePrinter p = new ReentrantSequencePrinter();
		new Thread(() -> p.printNumbers(1)).start();
		new Thread(() -> p.printNumbers(2)).start();
		new Thread(() -> p.printNumbers(3)).start();
	}
}
