package basic_class_01.design.impl;

import basic_class_01.design.Sort;

import static basic_class_01.Code_04_QuickSort.swap;

/**
 * @author liuzhaoxin
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2){
            return ;
        }
        for(int e = arr.length -1;e > 0;e--){
            for(int i = 0; i < e;i++){
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
}
