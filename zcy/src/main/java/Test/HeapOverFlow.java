package Test;

import java.util.ArrayList;

/**
 * @author liuzhaoxin
 */
public class HeapOverFlow {
    int[] arr = null;

    public HeapOverFlow() {
        this.arr = new int[1024000];
    }

    public static void main(String[] args) {
        ArrayList<HeapOverFlow> list = new ArrayList<HeapOverFlow>();

        int i = 0;
        while (true) {
            try {
                i++;
                System.out.println(i);
                list.add(new HeapOverFlow());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
