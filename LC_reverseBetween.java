package Coding;

public class LC_reverseBetween {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		LC_reverseBetween lc = new LC_reverseBetween();
		ListNode begin = lc.reverseBetween(node1, 2, 4);
		while (begin != null) {
			System.out.print(begin.val + "-> ");
			begin = begin.next;
		}
	}

	// 迭代法
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = head;
		ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		for (int i = 0; i < m - 1; i++)
			pre = pre.next;

		ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		ListNode then = start.next; // a pointer to a node that will be reversed

		// 1 - 2 - 3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5

		for (int i = 0; i < n - m; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5
		// (finish)

		return dummy.next;
	}

	// 我写的
	public ListNode reverseBetween0(ListNode head, int m, int n) {
		ListNode pre = null;
		ListNode next = null;
		ListNode newHead = head;
		int count = 0;
		while (count < m) {
			pre = newHead;
			newHead = newHead.next;
			count++;
		}
		ListNode nodem = pre;
		ListNode noden = pre.next;
		while (newHead != null && count < n) {
			next = newHead.next;
			newHead.next = pre;
			pre = newHead;
			newHead = next;
			count++;
		}
		nodem.next = pre;
		noden.next = next;
		return head;
	}

	// 递归法
	// Object level variables since we need the changes
	// to persist across recursive calls and Java is pass by value.
	private boolean stop;
	private ListNode left;

	public void recurseAndReverse(ListNode right, int m, int n) {

		// base case. Don't proceed any further
		if (n == 1) {
			return;
		}

		// Keep moving the right pointer one step forward until (n == 1)
		right = right.next;

		// Keep moving left pointer to the right until we reach the proper node
		// from where the reversal is to start.
		if (m > 1) {
			this.left = this.left.next;
		}

		// Recurse with m and n reduced.
		this.recurseAndReverse(right, m - 1, n - 1);

		// In case both the pointers cross each other or become equal, we
		// stop i.e. don't swap data any further. We are done reversing at this
		// point.
		if (this.left == right || right.next == this.left) {
			this.stop = true;
		}

		// Until the boolean stop is false, swap data between the two pointers
		if (!this.stop) {
			int t = this.left.val;
			this.left.val = right.val;
			right.val = t;

			// Move left one step to the right.
			// The right pointer moves one step back via backtracking.
			this.left = this.left.next;
		}
	}

	public ListNode reverseBetween1(ListNode head, int m, int n) {
		this.left = head;
		this.stop = false;
		this.recurseAndReverse(head, m, n);
		return head;
	}
}
