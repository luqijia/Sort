package com.select;

import java.util.Iterator;

/**
 * 堆排序
 * 
 * @author luqijia
 *
 */
public class HeapSort {

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * 下滤
	 * 
	 * @param arr 需要调整的数组
	 * @param i   需要调整的起始位置
	 * @param n   需要调整的元素个数
	 */
	private static void percDown(int[] arr, int i, int n) {
		int child;
		int temp;
		for (temp = arr[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && arr[child] < arr[child + 1]) {
				child++;
			}
			if (temp < arr[child]) {
				arr[i] = arr[child];
			} else {
				break;
			}
		}
		arr[i] = temp;
	}

	/**
	 * 元素交换
	 * 
	 * @param arr
	 * @param i   要交换的元素位置
	 * @param j   要交换的元素位置
	 */
	private static void swapReferences(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 堆排序
	 */
	public static void heapSort(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) { // 构建堆
			percDown(arr, i, arr.length);
		}
		for (int i = arr.length - 1; i > 0; i--) {
			swapReferences(arr, 0, i); // 交换元素位置，相当于删除堆的第一个元素
			percDown(arr, 0, i); // 重新调整堆，原因是第一个元素被调换了
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 85, 45, 22, 31, 12, 46, 22 };
		System.out.println("未排序前数组:");
		printArr(arr);
		System.out.println("排序后的数组:");
		heapSort(arr);
		printArr(arr);
	}
}
