package page_001_020;

import java.util.*;

/**
 * @author liuzhaoxin
 */
public class WordBreak {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("123lzx");
        final StringBuffer stringBuffer = sb.deleteCharAt(sb.length() - 1);
        System.out.println(stringBuffer.toString());
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s,wordDict,new HashMap<>());
    }
    private List<String> helper(String s,List<String> wordDict,Map<String,List<String>> map){
        if(map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<>();

        if(s == null || s.length() == 0){
            return res;
        }
        for(String word:wordDict){
            //说明以该字符串开头
            if(s.startsWith(word)){
                if(s.length() == word.length()){
                    res.add(s);
                }else{
                    List<String> sublist = helper(s.substring(word.length()),wordDict,map);
                    for(String subStr: sublist){
                        res.add(word +" "+ subStr);
                    }
                }

            }
        }
        map.put(s,res);
        return res;
    }
}
