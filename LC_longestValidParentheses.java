package Coding;

import java.util.Deque;
import java.util.LinkedList;

public class LC_longestValidParentheses {

	public static void main(String[] args) {
		LC_longestValidParentheses lc = new LC_longestValidParentheses();
		String[] s = {"())","()(())",")()())","())()","())","()(()"};
		for(int i=0;i<s.length;i++) {
			System.out.println(lc.longestValidParentheses1(s[i]));
		}		
	}

	//未完善算法
	public int longestValidParentheses2(String s) {
		Deque<Character> stack = new LinkedList();
		int count = 0;
		boolean pos = false;
		char[] chr = s.toCharArray();
		for (int i = 0; i < chr.length; i++) {
			if (chr[i] == '(') {
				stack.push(chr[i]);
				pos = true;
			} else {
				if (chr[i] == ')') {
					if (!pos)
						continue;
					if (!stack.isEmpty() && stack.pop() == '(') {
						count++;						
					} else {
						break;
					}
				}
			}
		}
		return count * 2;
	}
	
	public int longestValidParentheses(String s) {
		int maxans = 0;
		Deque<Integer> stack = new LinkedList();
		//"())"   "()(())"   ")()())"    "())()"    "())"    "()(()"
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}
	
	public int longestValidParentheses1(String s) {
        //String[] s = {"())","()(())",")()())","())()","())","()(()","(()","())"};
		int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        //"())"
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
