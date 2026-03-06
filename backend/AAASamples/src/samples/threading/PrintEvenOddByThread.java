package samples.threading;

public class PrintEvenOddByThread {

	public static void main(String[] args) {
		
		Runnable task = () -> {
			for(int i=1;i<11;i++) {
				if(i%2!=0) {
					System.out.println(Thread.currentThread().getName()+" prints "+i);
				}else {
					System.out.println(Thread.currentThread().getName()+" prints "+i);
				}
			}
		};
		
		Thread t1 = new Thread(task, "EvenThread");
		Thread t2 = new Thread(task, "OddThread");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
