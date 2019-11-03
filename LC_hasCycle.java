package Coding;

import java.util.HashSet;
import java.util.Set;

public class LC_hasCycle {

	public static void main(String[] args) {

		ListNode node = new ListNode(2);
		node.next = new ListNode(3);
		node.next.next=node;

		LC_hasCycle lc = new LC_hasCycle();
		System.out.println(lc.hasCycle2(node));
	}

	public boolean hasCycle(ListNode head) {
		boolean pos = false;
		Set<String> set = new HashSet<>();

		while (head != null) {
			System.out.println(head.val + " : " + head);
			if (set.contains(head.toString())) {
				pos = true;
				return pos;
			} else {
				set.add(head.toString());
				head = head.next;
			}
		}
		return pos;
	}
	
	public boolean hasCycle2(ListNode head) {
		if(head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast) {
			if(fast == null || fast.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
