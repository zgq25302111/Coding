package Coding;

import java.util.Arrays;

public class LC_reverseString {
	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o','m'};
		System.out.println(Arrays.toString(s));
		LC_reverseString lc = new LC_reverseString();
		lc.reverseString(s);
		System.out.println(Arrays.toString(s));
	}

	public void reverseString(char[] s) {
		if(s.length == 0) {
			return;
		}
		int len = s.length - 1;
		char tmp;
		for (int i = 0; i <= len / 2; i++) {
			tmp = s[i];
			s[i] = s[len - i];
			s[len - i] = tmp;
		}
	}
}
