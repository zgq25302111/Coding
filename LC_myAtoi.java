package Coding;

public class LC_myAtoi {

	public static void main(String[] args) {
		String str = " ";
		LC_myAtoi lc = new LC_myAtoi();
		System.out.println(lc.myAtoi(str));
	}

	public int myAtoi(String str) {
		if (str.isEmpty() || str.trim().isEmpty())
			return 0;
		int sign = 1, base = 0, i = 0;
		while (str.charAt(i) == ' ')
			i++;
		if (str.charAt(i) == '-' || str.charAt(i) == '+')
			sign = str.charAt(i++) == '-' ? -1 : 1;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = 10 * base + (str.charAt(i++) - '0');
		}
		return base * sign;
	}

}
