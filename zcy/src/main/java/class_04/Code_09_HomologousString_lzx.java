package class_04;

/**
 * @author liuzhaoxin
 * <p>
 * 找同源异构字符串！！！！！
 * <p>
 * 给定一个长度为m的字符串aim,以及一个长度为n的字符串str,问能否在str中找到一个长度为m的连续子串，
 * 使得这个子串刚好由aim的m个字符构成，顺序无所谓，返回任意满足条件的子串的起始位置，未找到返回-1
 */
public class Code_09_HomologousString_lzx {

    public static int process(String s, String a) {
        if (s.length() < a.length()) {
            return -1;
        }
        int M = a.length();
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        int[] count = new int[256];
        for (char c : aim) {
            count[c]++;
        }
        int invalidTimes = 0;
        int R = 0;
        for (; R < M; R++) {
            if (count[str[R]]-- <= 0) {
                invalidTimes--;
            }
        }

        for (; R < str.length; R++) {
            if (invalidTimes == 0) {
                return R - M;
            }
            if (count[str[R]]-- <= 0) {
                invalidTimes++;
            }
            if (count[str[R - M]]++ < 0) {
                invalidTimes--;
            }
        }
        return invalidTimes == 0 ? R - M : -1;
    }

    public static void main(String[] args) {

    }
}
