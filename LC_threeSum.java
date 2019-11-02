import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC_threeSum {

	public static void main(String[] args) {
		LC_threeSum lc_threeSum = new LC_threeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> rslist = new ArrayList<>();
		Arrays.sort(nums);		
		System.out.println(Arrays.toString(nums));
		rslist = lc_threeSum.threeSum2(nums);
		for (List<Integer> s : rslist) {
			System.out.println(s.toString());
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rslist = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int x = 0 - nums[i] - nums[j];
				if (nums[j + 1] == x) {
					List<Integer> list = List.of(nums[i], nums[j], nums[j + 1]);
					rslist.add(list);
				}
			}
		}
		return rslist;
	}
	
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
		int len = nums.length;
		if (nums == null || len < 3)
			return ans;
		Arrays.sort(nums); // 排序
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0)
				break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // 去重
			int L = i + 1;
			int R = len - 1;
			while (L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
					while (L < R && nums[L] == nums[L + 1])
						L++; // 去重
					while (L < R && nums[R] == nums[R - 1])
						R--; // 去重
					L++;
					R--;
				} else if (sum < 0)
					L++;
				else if (sum > 0)
					R--;
			}
		}
		return ans;
	}
}
