package samples.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
	private int count = 0;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	//read and write locks are taken separately from main lock impl
	private final Lock readLock = lock.readLock(); 
	private final Lock writeLock = lock.writeLock();

	public void increment() {
		// when a writing thread has locked count var then all threads with readLock wait
		writeLock.lock();
		try {
			count++;
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			writeLock.unlock();
		}
	}

	public int getCount() {
		// when a writing thread has finished on count var then all threads with readLock can access
		readLock.lock();
		try {
			return count;
		} finally {
			readLock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReadWriteCounter counter = new ReadWriteCounter();

		Runnable readTask = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
				}
			}
		};

		Runnable writeTask = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					counter.increment();
					System.out.println(Thread.currentThread().getName() + " incremented");
				}
			}
		};

		Thread writerThread = new Thread(writeTask);
		Thread readerThread1 = new Thread(readTask);
		Thread readerThread2 = new Thread(readTask);

		writerThread.start();
		readerThread1.start();
		readerThread2.start();

		writerThread.join();
		readerThread1.join();
		readerThread2.join();

		System.out.println("Final count: " + counter.getCount());
	}
}
