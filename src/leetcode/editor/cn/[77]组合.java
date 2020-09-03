//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new ArrayList<>();
            combine0(n,1,k,new Stack<>(),ret);
            return ret;
        }

        private void combine0(int n, int begin, int k, Stack<Integer> stack, List<List<Integer>> list) {
            if (k == 0) {
                list.add(new ArrayList<>(stack));
                return;
            }
            for (int i = begin; i <= n; i++) {
                stack.push(i);
                combine0(n,i+1,k-1,stack,list);
                stack.pop();
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}