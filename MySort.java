package Coding;

import java.util.Arrays;

public class MySort {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 1, 3, 2 };
		MySort mysort = new MySort();
		mysort.shellSort(arr, 6);
		System.out.println(Arrays.toString(arr));
	}

	public void bubbleSort(int[] a, int n) {
		if (n <= 1)
			return;
		int tmp;
		boolean flag;
		for (int i = 0; i < n; i++) {
			flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true;
				}
			}
			if (!flag)
				break;
		}
	}
	
	public void insertionSort(int[] a, int n) {
		if (n <= 1) {
			return;
		}
		for (int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (a[j] > value) {
					a[j + 1] = a[j];  //a[j+1]==a[i],a[i]已变化
				} else {
					break;			  //跳出本趟循环 已排序区间末数小于a[i],已排序区间都不用跟a[i]比较
				}
			}
			a[j + 1] = value;
		}
	}
	
	public void shellSort(int[] a, int n) {
        int tmp;
        for (int step = n / 2; step >= 1; step /= 2) {
            for (int i = step; i < n; i++) {
            	tmp = a[i];
                int j = i - step;
                while (j >= 0 && a[j] > tmp) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = tmp;
            }
        }
    }
	
	public void selectionSort(int[] a, int n) {
	       if (n <= 1)
	           return;
	       for (int i = 0; i < n; i++) {
	           int minIndex = i;
	           for (int j = i; j < n; j++) {
	               if (a[j] < a[minIndex]) //找到最小的数
	                   minIndex = j; //将最小数的索引保存
	           }
	           int tmp = a[minIndex];
	           a[minIndex] = a[i];
	           a[i] = tmp;
	       }
	}
}
