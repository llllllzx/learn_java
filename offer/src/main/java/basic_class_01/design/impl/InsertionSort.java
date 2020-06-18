package basic_class_01.design.impl;

import basic_class_01.design.Sort;

import static basic_class_01.Code_01_InsertionSort.swap;


/**
 * @author liuzhaoxin
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
                    swap(arr,j,j+1);
            }
        }
    }
}
