//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence{
      public static void main(String[] args) {
           Solution solution = new LongestConsecutiveSequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxNum=1;
        for (Integer num : set) {
            if(set.contains(num-1)){
                continue;
            }
            int temp=num+1;
            int tempMax=1;
            while (set.contains(temp)){
                tempMax++;
                if(tempMax>maxNum){
                    maxNum=tempMax;
                }
                temp++;
            }
        }
        return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }