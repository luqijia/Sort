package com.quick;

import com.insert.InsertSort;

/**
 * 快速排序
 * 
 * @author luqijia
 *
 */
public class QuickSort {

	private static int CUTOFF = 5;

	/**
	 * 快速排序(驱动程序)
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	/**
	 * 执行三数中值分割法的程序
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int median3(int[] arr, int left, int right) {
		int center = (left + right) / 2;
		if (arr[center] < arr[left]) {
			swapReferences(arr, left, center);
		}
		if (arr[right] < arr[left]) {
			swapReferences(arr, left, right);
		}
		if (arr[right] < arr[center]) {
			swapReferences(arr, center, right);
		}

		// 将枢轴置于right-1的位置
		swapReferences(arr, center, right - 1);
		return arr[right - 1];
	}


	/**
	 * 元素交换
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void swapReferences(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left + CUTOFF <= right) {
			int pivot = median3(arr, left, right);
			int i = left;
			int j = right - 1;
			for (;;) {
				while (arr[++i] < pivot) {
				}
				while (arr[--j] > pivot) {
				}
				if (i < j) {
					swapReferences(arr, i, j);
				} else {
					break;
				}
			}
			swapReferences(arr, i, right - 1); // 恢复枢轴
			quickSort(arr, left, i - 1); // 排序小元素
			quickSort(arr, i + 1, right); // 排序大元素
		} else {
			insertionSort(arr, left, right); // 在子数组上执行插入排序
		}
	}

	private static void insertionSort(int[] arr, int left, int right) {
		int[] subArr = new int[right - left + 1];
		int tmp = left;
		for (int i = 0; i < subArr.length; i++) {
			subArr[i] = arr[tmp];
			tmp++;
		}
		InsertSort.insertionSort(subArr);
		for (int i = 0; i < subArr.length; i++) {
			arr[left] = subArr[i];
			left++;
		}
	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 12, 21, 44, 23, 10, 41, 66, 25 };
		System.out.println("未排序前数组:");
		printArr(arr);
		System.out.println("排序后数组:");
		quickSort(arr);
		printArr(arr);
	}

}
