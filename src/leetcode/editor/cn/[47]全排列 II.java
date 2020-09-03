//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] arr={1,1,2};
        solution.permuteUnique(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret=new ArrayList<>();
            boolean[] bol=new boolean[nums.length];
            Arrays.sort(nums);
            permuteUnique0(nums,bol,new Stack<>(),ret);
            return ret;
        }

        /**
         *
         * @param nums 数组
         * @param bol 确定某个元素是否被使用的bool数组
         * @param eles 栈
         * @param list 列表
         */
        private void permuteUnique0(int[] nums, boolean[] bol, Stack<Integer> eles,List<List<Integer>> list){
            if(eles.size()==nums.length){
                list.add(new ArrayList<>(eles));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if(!bol[i]){
                    if(i>0&&nums[i-1]==nums[i]&&!bol[i-1]){
                        continue;
                    }
                    eles.push(nums[i]);
                    bol[i]=true;
                    permuteUnique0(nums,bol,eles,list);
                    bol[i]=false;
                    eles.pop();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}