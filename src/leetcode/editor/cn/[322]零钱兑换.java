//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] arr={2};
        int ret=solution.coinChange(arr,3);
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[] array=new int[amount+1];
            Arrays.fill(array,amount+1);
            array[0]=0;
            for (int i = 1; i <=amount ; i++) {
                for (int i1 = 0; i1 < coins.length; i1++) {
                    if(i>=coins[i1]){
                        array[i]=Math.min(array[i],array[i-coins[i1]]+1);
                    }
                }
            }
            return array[amount]>amount?-1:array[amount];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}