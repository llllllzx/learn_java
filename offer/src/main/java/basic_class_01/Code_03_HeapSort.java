package basic_class_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Code_03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSortForLzx(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSortForLzx(arr);
		printArray(arr);
	}


	public static void heapSortForLzx(int[] arr){
		if(arr == null || arr.length == 0){
			return;
		}
		//初始化堆
		for(int i = 0;i<arr.length;i++){
			heapInsertForLzx(arr,i);
		}
		int heapSize = arr.length;
		swap(arr,0,--heapSize);
		while(heapSize > 0){
			//此时0~heapSize范围内，大根堆的结构已被破坏
			heapifyForLzx(arr,0,heapSize);
			swap(arr,0, --heapSize);
		}

	}

	private static void heapifyForLzx(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = left  +1;
		while(left < heapSize){
			int largest = right < heapSize && arr[right] > arr[left] ? right:left;
			largest = arr[index] > arr[largest] ? index :largest;
			if(largest == index){
				break;
			}
			swap(arr,largest,index);

			index = largest;
			left = index * 2 + 1;
			right = left  +1;
		}
	}

	private static void heapInsertForLzx(int[] arr, int index) {
		//当index为0的时候 (index-1)/2还是为0，所以arr[0]不可能大于arr[0],此时挑出循环
		while(arr[index] > arr[(index -1)/2]){
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}

}
