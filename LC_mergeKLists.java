package Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_mergeKLists {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next=new ListNode(4);
		list1.next.next=new ListNode(5);
		
		ListNode list2 = new ListNode(1);
		list2.next=new ListNode(3);
		list2.next.next=new ListNode(4);
		
		LC_mergeKLists lc = new LC_mergeKLists();
		ListNode head=lc.mergeTwoLists(list1,list2);
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}

		
//		ListNode list3 = new ListNode(2);
//		list3.next=new ListNode(6);
//		
//		ListNode[] lists = {list1, list2, list3};
//		
//		LC_mergeKLists lc = new LC_mergeKLists();
//		ListNode head = lc.mergeKLists3(lists);
//		while(head != null) {
//			System.out.print(head.val+" -> ");
//			head = head.next;
//		}
	}
	//暴力
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		List<Integer> arr = new ArrayList<>();
		int count = 0;
		ListNode head = lists[0];
		ListNode current;
		for (int i = 0; i < lists.length; i++) {
			current = lists[i];
			while (current != null) {
				arr.add(current.val);
				count = count + 1;
				current = current.next;
			}
		}
		Integer[] res = arr.toArray(new Integer[count]);
		Arrays.sort(res);
		System.out.println(Arrays.toString(res));
		ListNode ncurrent;
		if(res.length>0) {
			ncurrent = new ListNode(res[0]);
		} else {
			return null;
		}		 
		ListNode nhead=ncurrent;
		for (int i = 1; i < count; i++) {
			ncurrent.next=new ListNode(res[i]);
			ncurrent=ncurrent.next;
		}
		return nhead;
	}
	
//	public ListNode mergeKLists2(ListNode[] lists) {
//		if (lists == null || lists.length == 0)
//			return null;
//		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//			@Override
//			public int compare(ListNode o1, ListNode o2) {
//				if (o1.val < o2.val)
//					return -1;
//				else if (o1.val == o2.val)
//					return 0;
//				else
//					return 1;
//			}
//		});
//		ListNode dummy = new ListNode(0);
//		ListNode p = dummy;
//		for (ListNode node : lists) {
//			if (node != null)
//				queue.add(node);
//		}
//		while (!queue.isEmpty()) {
//			p.next = queue.poll();
//			p = p.next;
//			if (p.next != null)
//				queue.add(p.next);
//		}
//		return dummy.next;
//	}
	//分治
	public ListNode mergeKLists3(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return merge(lists, 0, lists.length - 1);
	}

	public ListNode merge(ListNode[] lists, int left, int right) {
		if (left == right)
			return lists[left];
		int mid = left + (right - left) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		prev.next = l1 == null ? l2 : l1;
		return prehead.next;
	}
}















