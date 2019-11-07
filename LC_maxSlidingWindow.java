package Coding;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC_maxSlidingWindow {

	public static void main(String[] args) {
		int[] nums = { 1, 7, 6, -3, 5, 3, -1, 3 };
		int k = 3;
		LC_maxSlidingWindow lc = new LC_maxSlidingWindow();
		System.out.println(Arrays.toString(lc.maxSlidingWindow(nums, k)));
	}
	
	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n - k + 1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			//q就是窗口，始终最多只有k个元素，只要小于，就把前面的数全扔掉才能剩下最多k个
			while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
				q.pollFirst();
			}
			// remove smaller numbers in k range as they are useless
			//只要新增数据（在队尾）比前面数据大，前面数据都扔掉，保证队首数据总是最大，再结合上面while循环，保证窗口内的队首数据最大，
			//后面的if语句只要取队首就可以
			//如果新增数据比队尾数据小，就添加到队尾。队列数据是从大到小序列
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offerLast(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peekFirst()];
			}
		}
		return r;
	}
}
