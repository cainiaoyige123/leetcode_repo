//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ret=new ArrayList<>();
        int n=0;
        public List<String> generateParenthesis(int n) {
            this.n=n;
            generate("",0,2*n);
            return ret;
        }

        /**
         *
         * @param str 生成的有效字符
         * @param sum　前面的和
         * @param leave　还剩下可生成的括号数
         */
        public void generate(String str,int sum,int leave){
            if(sum>0||sum<-this.n){
                return;
            }
            if(leave<=0){
                if(sum==0){
                    ret.add(str);
                }
                return;
            }
            leave--;
            if(sum<0){
                int sum1=sum+1;
                generate(str+")",sum1,leave);
            }
            sum-=1;
            generate(str+"(",sum,leave);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}