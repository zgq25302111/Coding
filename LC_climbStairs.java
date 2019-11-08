package Coding;

import java.util.HashMap;
import java.util.Map;

public class LC_climbStairs {

	public static void main(String[] args) {
		LC_climbStairs lc = new LC_climbStairs();
		System.out.println(lc.climbStairs(10));
	}

	public int climbStairs2(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			if (map.containsKey(n)) {
				return map.get(n);
			} else {
				map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
				return map.get(n);
			}
		}
	}
	
	public int climbStairs(int n) {
		  if (n == 1) return 1;
		  if (n == 2) return 2;
		  
		  int ret = 0;
		  int pre = 2;
		  int prepre = 1;
		  for (int i = 3; i <= n; ++i) {
		    ret = pre + prepre;
		    prepre = pre;
		    pre = ret;
		  }
		  return ret;
	}
}
