package Coding;

public class LC_mySqrt {
	public static void main(String[] args) {
		LC_mySqrt lc = new LC_mySqrt();
		System.out.println(lc.mySqrt4(3));
	}
	//牛顿法
	public double mySqrt(double x) {
		double r = x;
	    while (r*r > x)
	        r = (r + x/r) / 2;
	    return r;
	}
	//以下标准答案  牛顿法超时 二分法算不对
	public int mySqrt4(int x) {
	    if (x == 0)
	        return 0;
	    int left = 1, right = Integer.MAX_VALUE;
	    while (true) {
	        int mid = left + (right - left)/2;
	        if (mid > x/mid) {
	            right = mid - 1;
	        } else {
	            if (mid + 1 > x/(mid + 1))
	                return mid;
	            left = mid + 1;
	        }
	    }
	}
	
	//二分法
	public double mySqrt2(double x, double precision) {
		if (x < 0) {
			return Double.NaN;
		}
		double low = 0;
		double high = x;
		if (x < 1 && x > 0) {
			/** 小于1的时候 */
			low = x;
			high = 1;
		}
		double mid = low + (high - low) / 2;
		while (high - low > precision) {
			if (mid * mid > x) {
				high = mid;
			} else if (mid * mid < x) {
				low = mid;
			} else {
				return mid;
			}
			mid = low + (high - low) / 2;
		}
		return mid;
	}
	
	public double mySqrt3(double x, double precision) {
		if (x < 0) {
			return Double.NaN;
		}
		double low = 0;
		double high = x;
		if (x < 1 && x > 0) {
			/** 小于1的时候 */
			low = x;
			high = 1;
		}
		double mid = low + (high - low) / 2;
		while (Math.abs(mid * mid - x) > precision) {
			if (mid * mid > x) {
				high = mid;
			} else if (mid * mid < x) {
				low = mid;
			} else {
				return mid;
			}
			mid = low + (high - low) / 2;
		}
		return mid;
	}
}