package samples.threading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterviewThreads {
	public static void main(String[] args) {
		int cabinCount = 5;
		int candidateCount = 200;
		Random rand = new Random();
		ExecutorService es = Executors.newFixedThreadPool(cabinCount);
		for (int i = 1; i <= candidateCount; i++) {
			
			int min = 10;
			int max = 1000;
			int randomNum = rand.nextInt(max - min + 1) + min;
			int finalI = i;
			es.submit(() -> {
				System.out.println("Candidate : "+finalI+" in cabin : "+Thread.currentThread().getName()+" for time: "+randomNum);
				
				try {
					Thread.sleep(randomNum);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
