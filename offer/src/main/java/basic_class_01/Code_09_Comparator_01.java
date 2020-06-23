package basic_class_01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhaoxin
 *
 *
 */
public class Code_09_Comparator_01 {
    public static void main(String[] args) {
        String [] strs = {"3","30","31","32","34","35"};
        //字典顺序：3  30  31  32  33  35
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2); // reverse order here, so we can do append() later
            }
        };
        Arrays.sort(strs,comp);

        for(String s : strs){
            System.out.print(s + "  ") ;
        }
    }
}
