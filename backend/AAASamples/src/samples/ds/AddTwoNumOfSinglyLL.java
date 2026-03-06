package samples.ds;

public class AddTwoNumOfSinglyLL {

	/*
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order, and each of their nodes
	 * contains a single digit. Add the two numbers and return the sum as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int digit1 = (l1 != null) ? l1.val : 0;
			int digit2 = (l2 != null) ? l2.val : 0;

			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(digit);
			tail.next = newNode;
			tail = tail.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}

		ListNode result = dummyHead.next;
		dummyHead.next = null;
		return result;
	}

	public static void main(String[] args) {
		/*
		 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] 
		 * Explanation: 342 + 465 = 807
		 */
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);

		l1.next = new ListNode(4, new ListNode(3));
		l2.next = new ListNode(6, new ListNode(4));

		ListNode res = addTwoNumbers(l1, l2);
		//will output 708 as it is linked in reverse
		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}

	}
}
