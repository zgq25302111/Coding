package Coding;

public class LC_reverseWords {

	public static void main(String[] args) {
		String s = "you may want to specify that you are wanting to create a record";
		LC_reverseWords lc = new LC_reverseWords();
		char[] str = s.toCharArray();
		lc.reverse(str,0,str.length-1);
		System.out.println(lc.reverseWords2(s));
	}

	public String reverseWords(String s) {
		s = s.trim();
		String regex = "\\s+";
		String str = s.replaceAll(regex, " ");
		String[] str_arr = str.split(" ");

		if (str_arr.length == 0) {
			return "";
		}
		int len = str_arr.length - 1;
		String tmp;
		for (int i = 0; i <= len / 2; i++) {
			tmp = str_arr[i];
			str_arr[i] = str_arr[len - i];
			str_arr[len - i] = tmp;
		}
		String rst = "";
		for (int i = 0; i < str_arr.length; i++) {
			rst = rst + " " + str_arr[i];
		}
		return rst.trim();
	}
	
	public String reverseWords2(String s) {
        if (s.length() < 1) return s; // empty string
        int startIdx = 0;
        char[] str = s.toCharArray();
        // reverse whole string
        reverse(str, 0, str.length - 1);
        // reverse word one by one
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                if (startIdx != 0) str[startIdx++] = ' ';
                int j = i;
                while (j < str.length && str[j] != ' ')
                    str[startIdx++] = str[j++];
                reverse(str, startIdx - (j - i), startIdx - 1); 
                i = j;
            }
        }
        return new String(str, 0, startIdx);
    }

    private void reverse(char[] str, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;
        }
    }
}
