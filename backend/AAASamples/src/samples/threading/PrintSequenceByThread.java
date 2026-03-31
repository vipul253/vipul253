package samples.interview;

public class PrintSequenceByThread {
	private int number = 1;
    private final int MAX = 10;
    private final int numberOfThreads = 3;

    public synchronized void printNumber(int threadId) {
        while (number <= MAX) {
            // Check if it's this thread's turn
            // Thread 1 handles (number % 3 == 1), Thread 2 (number % 3 == 2), Thread 3 (number % 3 == 0)
            if (number % numberOfThreads != (threadId % numberOfThreads)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else if (number <= MAX) {
                System.out.println("Thread " + threadId + ": " + number);
                number++;
                notifyAll(); // Wake up other threads to check the condition
            }
        }
    }

    public static void main(String[] args) {
    	PrintSequenceByThread printer = new PrintSequenceByThread();

        Thread t1 = new Thread(() -> printer.printNumber(1));
        Thread t2 = new Thread(() -> printer.printNumber(2));
        Thread t3 = new Thread(() -> printer.printNumber(3));

        t1.start();
        t2.start();
        t3.start();
    }
}
