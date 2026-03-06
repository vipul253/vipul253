package samples.threading;

class NumberPrinter {
	private int n;
	private int counter;

	public NumberPrinter(int n) {
		this.n = n;
		this.counter = 1;
	}

	public synchronized void printOdd() throws InterruptedException {
		while (counter <= n) {
			if (counter % 2 == 1) { // counter is odd, print it
				System.out.println("Odd thread : " + counter);
				counter++;
				notifyAll();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void printEven() throws InterruptedException {
		while (counter <= n) {
			if (counter % 2 == 0) { // counter is even, print it
				System.out.println("Even thread : " + counter);
				counter++;
				notifyAll();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
