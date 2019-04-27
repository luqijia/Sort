package com.merge;

/**
 * 归并排序
 * 
 * @author luqijia
 *
 */
public class MergeSort {

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] arr) {
		int[] tmpArr = new int[arr.length];
		mergeSort(arr, tmpArr, 0, arr.length - 1);
	}

	/**
	 * 
	 * @param arr    可比项目的数组
	 * @param tmpArr 放置合并结果的数组
	 * @param left   子数组的最左边的索引
	 * @param right  子数组的最右边的索引
	 */
	private static void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(arr, tmpArr, left, center);
			mergeSort(arr, tmpArr, center + 1, right);
			merge(arr, tmpArr, left, center + 1, right);
		}
	}

	/**
	 * 
	 * @param arr      可比项目的数组
	 * @param tmpArr   放置合并结果的数组
	 * @param leftPos  子数组的最左边的索引
	 * @param rightPos 下半段开始的索引
	 * @param rightEnd 子数组的最右边的索引
	 */
	private static void merge(int[] arr, int[] tmpArr, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (arr[leftPos] <= arr[rightPos]) {
				tmpArr[tmpPos++] = arr[leftPos++];
			} else {
				tmpArr[tmpPos++] = arr[rightPos++];
			}
		}
		while (leftPos <= leftEnd) { // 复制上半部分的其余部分
			tmpArr[tmpPos++] = arr[leftPos++];
		}
		while (rightPos <= rightEnd) { // 复制下半部分的其余部分
			tmpArr[tmpPos++] = arr[rightPos++];
		}

		// 将tmpArr复制回去
		for (int i = 0; i < numElements; i++, rightEnd--) {
			arr[rightEnd] = tmpArr[rightEnd];
		}
	}
	public static void main(String[] args) {
		int[] arr = {12,44,21,32,65,74,11,65,14,7};
		System.out.println("未排序前数组:");
		printArr(arr);
		System.out.println("排序后数组:");
		mergeSort(arr);
		printArr(arr);
	}
}
