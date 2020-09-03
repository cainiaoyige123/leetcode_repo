//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串


package leetcode.editor.cn;

import java.util.TreeMap;

class AddStrings {
    public static void main(String[] args) {

        Solution solution = new AddStrings().new Solution();
        String s = solution.addStrings("9", "99");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder num11=new StringBuilder(num1);
            num11=num11.reverse();
            StringBuilder num22=new StringBuilder(num2);
            num22=num22.reverse();
            int jin=0;
            int yu=0;
            int i=0;
            int len1=num1.length();
            int len2=num2.length();
            StringBuilder ret=new StringBuilder();
            while (true){
                if(i>=len1||i>=len2){
                    break;
                }
                char ch1=num11.charAt(i);
                char ch2=num22.charAt(i);
                i++;
                int num=(ch1+ch2-2*'0'+jin);
                jin=num/10;
                yu= num%10;
                ret.append(yu);
            }
            if(i<len1){
                while (i<len1){
                    char ch=num11.charAt(i);
                    int num=(ch+-'0'+jin);
                    jin=num/10;
                    yu= num%10;
                    ret.append(yu);
                    i++;
                }
            }else if(i<len2) {
                while (i<len2){
                    char ch=num22.charAt(i);
                    int num=(ch+-'0'+jin);
                    jin=num/10;
                    yu= num%10;
                    ret.append(yu);
                    i++;
                }
            }
            if(jin==1){
                ret.append(1);
            }
            return ret.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}