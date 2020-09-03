//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


package leetcode.editor.cn;

import java.util.Stack;

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap2(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //动态规划
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int maxL = 0;
            int[] rightMax = new int[height.length];
            int maxR = 0;
            int ret = 0;
            for (int i = 1; i < height.length; i++) {
                if (height[i - 1] > maxL) {
                    maxL = height[i - 1];
                }
                leftMax[i] = maxL;
            }
            for (int i = height.length - 2; i >= 0; i--) {
                if (height[i + 1] > maxR) {
                    maxR = height[i + 1];
                }
                rightMax[i] = maxR;
            }
            for (int i = 1; i < height.length - 1; i++) {
                int res = Math.min(leftMax[i], rightMax[i]) - height[i];
                if (res > 0) {
                    ret += res;
                }
            }
            return ret;
        }

        //双指针
        public int trap1(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int left = 0;
            int right = height.length - 1;
            int leftMax = height[left];
            int rightMax = height[right];
            int ret = 0;
            while (left < right) {
                if (leftMax < rightMax) {
                    left++;
                    if (height[left] > leftMax) {
                        leftMax = height[left];
                    } else {
                        ret += leftMax - height[left];
                    }
                } else {
                    right--;
                    if (height[right] > rightMax) {
                        rightMax = height[right];
                    } else {
                        ret += rightMax - height[right];
                    }
                }
            }
            return ret;
        }

        //递减栈法
        public int trap2(int[] height) {
            int len = height.length;
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            int ret=0;
            while (i < len) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {//如果当前的元素大于栈顶,需要计算雨水,自然栈不能为空
                    int topIndex=stack.pop();
                    if(stack.isEmpty())
                        break;
                    int h=Math.min(height[stack.peek()],height[i])-height[topIndex];
                    //int width=i-topIndex;topIndex并不一定等于stack.peek+1
                    int width=i-stack.peek()-1;
                    ret+=h*width;
                }
                stack.push(i++);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}