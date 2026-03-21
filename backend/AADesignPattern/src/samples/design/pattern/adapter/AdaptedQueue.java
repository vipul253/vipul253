package samples.design.pattern.adapter;

import java.util.Iterator;
import java.util.LinkedList;

public class AdaptedQueue<T> implements Iterable<T> {
	private LinkedList<T> queue;

	public AdaptedQueue() {
		this.queue = new LinkedList<T>();
	}

	public void enqueue(T e) {
		this.queue.addLast(e);
	}

	public T dequeue() {
		return this.queue.removeFirst();
	}

	public int count() {
		return this.queue.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.queue.iterator();
	}
}
