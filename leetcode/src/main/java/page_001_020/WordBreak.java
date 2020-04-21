package page_001_020;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhaoxin
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 */
public class WordBreak {

    public static void main(String[] args) {
        String str = "lzx123";
        Set<String> set = new HashSet<>();
        set.add("lzx");
        set.add("123");
        final boolean flag = new WordBreak().wordBreak(str, set);
        System.out.println(flag);
    }
    public boolean wordBreak(String s, Set<String> dict) {
        return helper(s, dict, new Hashtable<>());
    }

    private boolean helper(String s, Set<String> dict, Map<String, Boolean> map) {
        if (map.containsKey(s))
            return map.get(s);

        if (s == null || s.length() == 0) {
            return true;
        }
        boolean flag = false;
        for (String word : dict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    return true;
                } else {
                    flag = helper(s.substring(word.length()), dict, map);
                    if (!flag) {
                        continue;
                    }
                    flag = true;
                    break;
                }
            }
        }
        map.put(s, flag);
        return flag;
    }
}
