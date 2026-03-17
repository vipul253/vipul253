package samples.ds;

public class ReverseLL {

	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;    // 1. Save the next node before overwriting        
            cur.next = prev;    // 2. Reverse the 'next' pointer                   
            prev = cur;         // 3. Move 'prev' to the current node              
            cur = next;         // 4. Move 'curr' to the next node (saved in temp) 
        }                                                                          
        return prev;
    }
}
