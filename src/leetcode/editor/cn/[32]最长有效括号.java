//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
    }

    /*
    dp[i]=dp[i−2]+2
    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     */

    class Solution {
        public int longestValidParentheses(String s) {
            int[] dp=new int[s.length()];
            int max=0;
            for (int i = 1; i < s.length(); i++) {
                char ch=s.charAt(i);
                if (ch==')') {
                    char ch1=s.charAt(i-1);
                    if(ch1=='('){
                        dp[i]=2;
                        if(i-2>=0){
                            dp[i]=dp[i]+dp[i-2];
                        }
                        max=Math.max(max,dp[i]);
                    }else if(dp[i-1]>0) {
                        if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                            dp[i]=dp[i-1]+2;
                            if(i-dp[i-1]-2>=0){
                                dp[i]=dp[i]+dp[i-dp[i-1]-2];
                            }
                            max=Math.max(max,dp[i]);
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}