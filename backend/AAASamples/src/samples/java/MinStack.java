package samples.java;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;

	public MinStack() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}

	// Push element x onto stack
	public void push(int x) {
		mainStack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		} else {
			minStack.push(minStack.peek()); // Push the current minimum again
		}
	}

	// Removes the element on top of the stack
	public void pop() {
		if (!mainStack.isEmpty()) {
			mainStack.pop();
			minStack.pop(); // Keep the minStack in sync
		}
	}

	// Get the top element
	public int top() {
		if (!mainStack.isEmpty()) {
			return mainStack.peek();
		}
		throw new RuntimeException("Stack is empty");
	}

	// Retrieve the minimum element in the stack
	public int getMin() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		throw new RuntimeException("Stack is empty");
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(18);
		stack.push(5);
		stack.push(14);
		stack.push(55);
		stack.push(2);

		System.out.println("Current Minimum: " + stack.getMin()); // Output: 2
		stack.pop(); // Pop 2
		System.out.println("Top Element: " + stack.top()); // Output: 55
		System.out.println("Current Minimum after pop: " + stack.getMin()); // Output: 5
	}

}
