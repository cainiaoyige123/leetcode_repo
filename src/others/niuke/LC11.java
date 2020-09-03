package others.niuke;
/* gh
 * 2020/8/10
 * 下午9:17
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LC11 {
    public static void main(String[] args) {
        String s="catsanddog";
        Set<String> dict=new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> strings = new LC11().wordBreak(s, dict);
        System.out.println(strings);
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret=new ArrayList<>();
        wordBreak1(s,-1,dict,new StringBuilder(),ret);
        return ret;
    }
    /**
     *
     * @param s 字符串
     * @param i　以ｉ为结尾的字符串
     * @param dict　字典
     * @param str 以ｉ结尾的分割字符串
     */
    public void wordBreak1(String s,int i,Set<String> dict,StringBuilder str,ArrayList<String> list){
        if(i>=s.length()-1){
            list.add(str.toString().trim());
            return;
        }
        for (int j = i+1; j < s.length(); j++) {
            String st=s.substring(i+1,j+1);
            if(dict.contains(st)){
                str.append(st).append(" ");
                wordBreak1(s,j,dict,str,list);
                int len=str.length();
                int start=len-(j-i)-1;
                str.delete(start,len);
            }

        }
    }
}
