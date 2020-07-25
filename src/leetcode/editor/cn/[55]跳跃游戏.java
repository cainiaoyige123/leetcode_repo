//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] arr = {2, 1, 0, 0};
        System.out.println(solution.canJump(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    if (nums[i + 1] != 0 && i + 1 != nums.length)
                        list.add(i + 1);
                }
            }
            if(list.size()==1){
                if(nums[nums.length-1]==0){

                }
            }
            boolean flag = true;
            for (int i = 0; i < list.size() - 1; i++) {
                flag &= canJump0(nums, list.get(i), list.get(i + 1));
            }
            return flag;
        }

        public boolean canJump0(int[] nums, int start, int end) {
            return nums[start] != 0 && nums[end - 2] >= 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}