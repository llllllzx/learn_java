package basic_class_01.design.impl;

import basic_class_01.design.Sort;

import static basic_class_01.Code_04_QuickSort.swap;

/**
 * @author liuzhaoxin
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }
}
