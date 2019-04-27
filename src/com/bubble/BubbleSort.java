package com.bubble;
/**
 * 冒泡排序
 * @author luqijia
 *
 */
public class BubbleSort {
	
	/**
	 * 打印数组
	 * @param arr
	 */
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
	
	/**
	 * 元素交换
	 */
	public static void swapArr(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 冒泡排序
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { //外层循环控制趟数
			for (int j = 0; j < arr.length-i; j++) {  //内层循环控制比较数
				if (arr[j]>arr[j+1]) {
					swapArr(arr, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10,21,5,6,1,80,66};
		System.out.println("未排序前的数组:");
		printArr(arr);
		System.out.println("排序后的数组:");
		bubbleSort(arr);
		printArr(arr);
	}
}
