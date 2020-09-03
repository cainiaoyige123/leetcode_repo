//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int len=nums.length;
            List<List<Integer>> ret=new ArrayList<>();
            for (int i = 0; i <= len; i++) {//按子集元素个数便利
                subsets0(nums,0,i,ret,new Stack<>());
            }
            return ret;
        }


        /**
         *
         * @param nums 数组
         * @param begin 开始索引
         * @param leave 还剩下的元素个数
         * @param list 返回的列表
         */
        public void subsets0(int[] nums, int begin, int leave, List<List<Integer>> list, Stack<Integer> ele){
            if(leave==0){
                list.add(new ArrayList<>(ele));
                return;
            }
            for (int i = begin; i < nums.length; i++) {
                ele.push(nums[i]);
                subsets0(nums,i+1,leave-1,list,ele);
                ele.pop();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}