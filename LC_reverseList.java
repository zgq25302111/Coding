package Coding;

import Coding.ListNode;

public class LC_reverseList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next=node3;
		node3.next=node4;
		
		LC_reverseList lc = new LC_reverseList();
		ListNode newHead = lc.reverseList(node1);
		while(newHead != null) {
			System.out.print(newHead.val+"-> ");
			newHead = newHead.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;  //改变指针方向
            pre = head;
            head = next;
        }
        return pre;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode p = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}	
}