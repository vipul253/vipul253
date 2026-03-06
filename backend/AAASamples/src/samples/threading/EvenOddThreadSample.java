package samples.threading;

import java.util.Scanner;

public class EvenOddThreadSample {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
		int limit = Integer.parseInt(in.nextLine());
        NumberPrinter numberPrinter = new NumberPrinter(limit);

        Thread oddThread = new Thread(() -> {
            try {
                numberPrinter.printOdd();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                numberPrinter.printEven();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        evenThread.start();
        oddThread.start();
        in.close();
    }
}
