package samples.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	private int count = 0;
	
	//lock class provides customing locking as sometimes 
	//using synchronized has issues like when a thread withdrawing from bank account 
	//then if that thread gets stuck in there, the other threads get stuck indefinitely
	//Lock is interface, reentrant is an implementation of lock
	private final Lock lock = new ReentrantLock();
	
	//synch at method level
	public synchronized void incrementSynched() {
		//synch at block level if other code is also there which does not need synch
		synchronized (this) {		
			count++;
		}
	}
	
	//custom condition based locking
	public void incrementWithCustomLock() {
		System.out.println(Thread.currentThread().getName()+" attempting to increase counter");
		try {
			//if already locked then wait only 1 second to acquire lock, else go back
			if(lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
				try {
					System.out.println(Thread.currentThread().getName()+" acquired lock");
					count++;
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName()+" incremented to "+ count);
				}catch(Exception e){
					//thread interrupted exception handling
				}finally {
					//always remember to release lock finally
					lock.unlock();
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" could not lock, try again");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int getCount() {
		return count;
	}
}
