package Coding;
/*
 * 1、数字入栈要捕获异常，否则编译错
 * 2、字符串比较要用equals，否则出现意想不到的报错
 * 
 * autho:一杯山楂水
 * */
import java.util.Deque;
import java.util.LinkedList;

public class LC_evalRPN {

	public static void main(String[] args) {
		String[] str = {"2","1","+","3","*"};
		LC_evalRPN lc = new LC_evalRPN();
		System.out.println(lc.evalRPN(str));
	}
	
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new LinkedList();
		int val=0;
		for(String s : tokens) {
			if(s.equals("+")) {
				val = stack.pop() + stack.pop();
				stack.push(val);
			} else if(s.equals("-")) {
				int x = stack.pop();
				int y = stack.pop();
				val = y - x;
				stack.push(val);
			} else if(s.equals("*")) {
				val = stack.pop() * stack.pop();
				stack.push(val);
			} else if(s.equals("/")) {
				int x = stack.pop();
				int y = stack.pop();
				val = y / x;
				stack.push(val);
			} else {
				try {
					stack.push(Integer.valueOf(s));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				
			}
		}
		return stack.pop();
	}
}
