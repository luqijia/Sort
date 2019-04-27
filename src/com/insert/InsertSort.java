package com.insert;

/**
 * 插入排序
 * 
 * @author luqijia
 *
 */
public class InsertSort {

	/**
	 * 插入排序
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		int j;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			for (j = i; j > 0 && temp < (arr[j - 1]); j--) {
				arr[j] = arr[j - 1]; // 移动元素
			}
			arr[j] = temp;
		}
	}

	/**
	 * 打印数组
	 * @param arr
	 */
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {12,10,45,21,5,9,45};
		System.out.println("未排序前数组:");
		printArr(arr);
		System.out.println("排序后数组:");
		insertionSort(arr);
		printArr(arr);
	}
}
