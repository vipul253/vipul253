package samples.design.pattern.adapter;

public class Test {
	public static void main(String[] args) {

		AdaptedQueue<Integer> numq = new AdaptedQueue<Integer>();
		numq.enqueue(10);
		numq.enqueue(20);
		numq.enqueue(30);
		// numq.enqueue("abc");
		System.out.println(numq.count());
		System.out.println(numq.dequeue());
		System.out.println(numq.count());

		for (Integer n : numq) {
			System.out.println(n);
		}
	}
}
