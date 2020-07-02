package class_08;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_08_Money_Problem_01 {


    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int coinChange(int[] coins, int amount) {
            if (map.get(amount) != null) return map.get(amount);
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int subnum = coinChange(coins, amount - coins[i]);
                if (subnum == -1) continue;
                res = Math.min(res, subnum + 1);
            }
            map.put(amount, res != Integer.MAX_VALUE ? res : -1);
            return map.get(amount);
        }
    }


    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subnum = coinChange1(coins, amount - coins[i]);
            if (subnum == -1) continue;
            res = Math.min(res, subnum + 1);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }


    public int coinChange2(int[] coins, int amount) {
        if (amount < 0) return -1;
        // dp[i] 代表金额为i的时候，最少需要的硬币数
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if ((i - coin) < 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
    }

}
