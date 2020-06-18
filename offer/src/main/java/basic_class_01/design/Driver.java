package basic_class_01.design;

import basic_class_01.design.impl.*;

/**
 * @author liuzhaoxin
 */
public class Driver {
    public static void main(String[] args) {
        Verification b = new Verification(new BubbleSort(), "冒泡");
        System.out.println(b.verify());

        Verification insertSort = new Verification(new InsertionSort(), "插入");
        System.out.println(insertSort.verify());

        Verification mergeSort = new Verification(new MergeSort(), "归并");
        System.out.println(mergeSort.verify());

        Verification quickSort = new Verification(new QuickSort(), "快排");
        System.out.println(quickSort.verify());

        Verification heapSort = new Verification(new HeapSort(), "堆排");
        System.out.println(heapSort.verify());
    }
}
