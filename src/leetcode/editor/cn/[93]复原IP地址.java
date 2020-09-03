//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.List;

class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            return null;
        }

        /**
         *
         * @param s 原字符串的builder形式
         * @param lastDot 上一个点的位置
         * @param leave 还剩几个点需要标记
         * @param list
         */
        public void restoreIpAddresses0(StringBuilder s,int lastDot,int leave,List<String> list){
            if(leave==0){
                String str=s.substring(lastDot+1);
                if(str.length()<=3&&str.length()>=1){
                    if(str.length()==1){
                        list.add(s.toString());
                    }else {
                        int x=Integer.parseInt(str);
                        if(x<256){
                            list.add(s.toString());
                        }
                    }
                }
            }
            for (int i = lastDot+1; i < s.length(); i++) {

            }
        }

        public boolean isOk(StringBuilder stb,int begin,int end){
            if(end-begin==1){
                return true;
            }else {
                String s=stb.substring(begin,end+1);
                int n=Integer.parseInt(s);
                if(n<256){
                    return true;
                }
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}