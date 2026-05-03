package samples.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ESFSample2 {

	public static void main(String[] args) throws Exception {
		int proc = Runtime.getRuntime().availableProcessors();
		System.out.println("core count :" + proc);
		ExecutorService es = Executors.newFixedThreadPool(proc);

		Future<Integer> f1 = es.submit(new Sum(10));
		es.submit(new Greet("Geeta"));
		Future<Integer> f2 = es.submit(new Sum(1000));
		es.submit(new Greet("Rita"));
		Future<Integer> f3 = es.submit(new Sum(100000));
		es.submit(new Greet("Name"));

		System.out.println("sum1 " + f1.get());
		System.out.println("sum2 " + f2.get());
		System.out.println("sum3 " + f3.get());

		es.shutdown();
	}

}

class Sum implements Callable<Integer> {

	int val;

	Sum(int a) {
		val = a;
	}

	@Override
	public Integer call() throws Exception {
		int res = 0;
		for (int i = 1; i <= val; i++) {
			res += i;
		}
		return res;
	}
}

class Greet implements Runnable {

	String name;

	public Greet(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("hello " + name);
	}

}