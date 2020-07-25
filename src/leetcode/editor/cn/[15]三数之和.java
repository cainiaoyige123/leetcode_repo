//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(arr);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list=lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret=new ArrayList<>();
            int len=nums.length;
            sort0(nums,0,len-1);
            for (int i = 0; i < len-2; i++) {
                int j=i+1;
                int k=len-1;
                while (j<k){
                    int sum=nums[i]+nums[j]+nums[k];
                    List<Integer> list1=null;
                    if(ret.size()!=0){
                        list1 = ret.get(ret.size() - 1);
                    }
                    if(sum==0 ){
                        assert false;
                        if( nums[j]!=list1.get(1) && nums[k]!=list1.get(2)){
                            List<Integer> list=new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            ret.add(list);
                        }
                        j++;
                        k--;
                    }else if(sum<0){
                        j++;
                    }else {
                        k--;
                    }
                }
            }
            return ret;
        }

        public void sort0(int[] nums, int start, int end) {
            if (end <= start) {
                return;
            }
            int start0 = start;
            int end0 = end;
            int standard = nums[start];
            while (start < end) {
                while (start < end && nums[end] >= standard) {
                    end--;
                }
                while (start < end && nums[start] <= standard) {
                    start++;
                }
                if (start < end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
            }
            nums[start0] = nums[end];
            nums[end] = standard;
            sort0(nums, start0, end - 1);
            sort0(nums, end + 1, end0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}