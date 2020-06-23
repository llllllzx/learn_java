package basic_class_01.design.impl;

import basic_class_01.design.Sort;

import static basic_class_01.Code_03_HeapSort.swap;

/**
 * @author liuzhaoxin
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //初始化堆
        heapInsert(arr);
        //用来表示堆的大小
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, size);
            swap(arr, 0, --size);
        }
    }

    private void heapify(int[] arr, int size) {
        int index = 0;
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (arr[j] > arr[(j - 1) / 2]) {
                swap(arr, j, (j - 1) / 2);
                j = (j - 1) / 2;
            }
        }
    }
}
