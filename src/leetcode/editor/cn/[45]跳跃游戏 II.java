//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


package leetcode.editor.cn;

class JumpGameIi {
    public static void main(String[] args) {

        Solution solution = new JumpGameIi().new Solution();
        int[] arr={7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(solution.jump1(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心算法重在寻找合适的贪心策略
        //第一种：反向寻找
        public int jump(int[] nums) {
            if(nums.length<2){
                return 0;
            }
            int temp=nums.length-1;
            int times=0;
            while (true){
                if(nums[0]>=temp){
                    times++;
                    break;
                }
                for (int i = 0; i < nums.length; i++) {
                    if(nums[i]+i>=temp){
                        temp=i;
                        times++;
                        break;
                    }
                }
            }
            return times;
        }

        //第二种：正向
        //之前的一种错误想法
        public int jump1(int[] nums) {
            if(nums.length<2){
                return 0;
            }
            if(nums[0]>=nums.length){
                return 1;
            }
            int nextStepIndex=0;
            int tempIndex=0;
            int times=0;

            while (true){
                if(tempIndex>=nums.length-1){
                    break;
                }
                int val=nums[tempIndex];
                int maxIndex=-1;
                for (int i = 1; i <= val; i++) {//找出下一个跳得索引
                    if(tempIndex+i<nums.length&&maxIndex<nums[tempIndex+i]+tempIndex+i){
                        nextStepIndex=tempIndex+i;
                        maxIndex=nums[tempIndex+i]+tempIndex+i;
                    }
                }
                times++;
                if(tempIndex==nextStepIndex){
                    break;
                }
                tempIndex=nextStepIndex;
            }
            return times;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}