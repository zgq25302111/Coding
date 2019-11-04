package Coding;

import java.util.Deque;
import java.util.LinkedList;

public class LC_Stack_isValid {

	public static void main(String[] args) {
		LC_Stack_isValid lc = new LC_Stack_isValid();
		String s = "(__)";
		System.out.println(lc.isValid(s));
	}

	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		char[] chr = s.toCharArray();
		for (char c : chr) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if(stack.isEmpty())
					return false;
				if (c == ')' && stack.pop() != '(')
					return false;
				if (c == '}' && stack.pop() != '{')
					return false;
				if (c == ']' && stack.pop() != '[')
					return false;
			}
		}
		return stack.isEmpty();
	}
}
