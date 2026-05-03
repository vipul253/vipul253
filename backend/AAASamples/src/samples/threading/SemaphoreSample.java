package samples.threading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreSample {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		new IncThread("Ramesh", sem);
		new DecThread("Daniel", sem);
		new IncThread("Brijesh", sem);
		new DecThread("Divya", sem);
		new DecThread("Diya", sem);
		new IncThread("Dinesh", sem);
		new DecThread("Jiya", sem);
		new IncThread("Ganesh", sem);
		new IncThread("Mahesh", sem);
		new DecThread("Riya", sem);
	}
}

class Shared {
	public static AtomicInteger count = new AtomicInteger(0);
}

class IncThread extends Thread {
	String name;
	Semaphore sem;

	IncThread(String name, Semaphore sem) {
		this.name = name;
		this.sem = sem;
		new Thread(this).start();
	}

	public void run() {
		try {
			System.out.println(name + " is waiting to execute..");
			sem.acquire();
			System.out.println(name + " has got the permission.");
			for (int i = 1; i <= 5; i++) {
				Shared.count.getAndIncrement();
				System.out.println(name + " :" + Shared.count);
				Thread.sleep(200);

			}
			System.out.println();
			sem.release();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class DecThread extends Thread {
	String name;
	Semaphore sem;

	DecThread(String name, Semaphore sem) {
		this.name = name;
		this.sem = sem;
		new Thread(this).start();
	}

	public void run() {
		try {
			System.out.println(name + " is waiting to execute..");
			sem.acquire();
			System.out.println(name + " has got the permission.");
			for (int i = 1; i <= 5; i++) {
				Shared.count.getAndDecrement();
				System.out.println(name + " :" + Shared.count);
				Thread.sleep(200);

			}
			System.out.println();
			sem.release();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}