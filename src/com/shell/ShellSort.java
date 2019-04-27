package com.shell;

/**
 * 希尔排序
 * 
 * @author luqijia
 *
 */
public class ShellSort {

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * 希尔排序
	 * 
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
		int j;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) { // 控制增量序列
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 11, 54, 62, 7, 22, 16 };
		System.out.println("未排序前数组:");
		printArr(arr);
		System.out.println("排序后数组:");
		shellSort(arr);
		printArr(arr);
	}
}
