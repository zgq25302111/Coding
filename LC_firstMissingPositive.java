package Coding;

import java.util.Arrays;

public class LC_firstMissingPositive {

	public static void main(String[] args) {
		LC_firstMissingPositive lc = new LC_firstMissingPositive();
		int[] nums= {3,4,1,1,1,5,1,1,2,1};
		Arrays.parallelSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	// 排序，忽略前面的负数，相邻两数做差（后减前），如果差值大于1，前面的数+1作为返回值。
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		Arrays.sort(nums);
		int i = 0;
		while (nums[i] < 0 && i < nums.length - 1) {
			i++;
		}
		if (nums[i] < 0)
			return 1;
		if (nums[i] > 1)
			return 1;
		for (; i < nums.length - 1; i++) {
			int x = nums[i + 1] - nums[i];
			if (x > 1) {
				return nums[i] + 1;
			}
		}
		return nums[nums.length - 1] + 1;
	}
	
	public int firstMissingPositive2(int[] nums) {
		int n = nums.length;

		// 基本情况
		int contains = 0;
		for (int i = 0; i < n; i++)
			if (nums[i] == 1) {
				contains++;
				break;
			}

		if (contains == 0)
			return 1;

		// nums = [1]
		if (n == 1)
			return 2;

		// 用 1 替换负数，0，
		// 和大于 n 的数
		// 在转换以后，nums 只会包含
		// 正数
		for (int i = 0; i < n; i++)
			if ((nums[i] <= 0) || (nums[i] > n))
				nums[i] = 1;

		// 使用索引和数字符号作为检查器
		// 例如，如果 nums[1] 是负数表示在数组中出现了数字 `1`
		// 如果 nums[2] 是正数 表示数字 2 没有出现
		for (int i = 0; i < n; i++) {
			int a = Math.abs(nums[i]);
			// 如果发现了一个数字 a - 改变第 a 个元素的符号
			// 注意重复元素只需操作一次
			if (a == n)
				nums[0] = -Math.abs(nums[0]);
			else
				nums[a] = -Math.abs(nums[a]);
		}

		// 现在第一个正数的下标
		// 就是第一个缺失的数
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0)
				return i;
		}

		if (nums[0] > 0)
			return n;

		return n + 1;
	}
}
