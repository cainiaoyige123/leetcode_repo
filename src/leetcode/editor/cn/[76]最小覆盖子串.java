//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumWindowSubstring {
    public static void main(String[] args) {

        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = solution.minWindow("ab", "b");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int minStart=0;
            int minEnd=0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                if (map.containsKey(ch)) {
                    map.replace(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            int size = t.length();
            int tempSize = 0;
            int min=Integer.MAX_VALUE;
            boolean flag=false;
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    if (tempMap.containsKey(ch)) {
                        if (tempMap.get(ch) < map.get(ch)) {
                            tempSize++;
                        }
                        tempMap.replace(ch, tempMap.get(ch) + 1);
                    } else {
                        tempMap.put(ch, 1);
                        tempSize++;
                    }
                    if (tempSize >= size) {
                        flag=true;
                        for (; j <= i; j++) {
                            char ch1=s.charAt(j);
                            if(map.containsKey(ch1)){
                                if(map.get(ch1).equals(tempMap.get(ch1))){
                                    int temp=i-j+1;
                                    if(temp<min){
                                        min=temp;
                                        minStart=j;
                                        minEnd=i;
                                    }
                                    tempSize--;
                                    tempMap.replace(ch1,tempMap.get(ch1)-1);
                                    j++;
                                    break;
                                }else if(map.get(ch1)<tempMap.get(ch1)){
                                    tempMap.replace(ch1,tempMap.get(ch1)-1);
                                }
                            }
                        }
                    }
                }
            }
            if(flag){
                return s.substring(minStart,minEnd+1);
            }else {
                return "";
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}