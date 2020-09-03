package others.回溯;
/* gh
 * 2020/8/1
 * 下午4:32
 */

import java.util.HashSet;
import java.util.Set;

//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
public class StringGame {
    public static void main(String[] args) {

    }

    public String[] permutation(String S) {
        Set<String> set=new HashSet<>();
        permutation0(S,new StringBuilder(),set,new boolean[S.length()]);
        return set.toArray(new String[set.size()]);
    }

    public void permutation0(String s, StringBuilder stb, Set<String> set,boolean[] join){
        if(stb.length()==s.length()){
            set.add(stb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(!join[i]){
                stb.append(s.charAt(i));
                join[i]=true;
                permutation0(s,stb,set,join);
                stb.deleteCharAt(stb.length()-1);
                join[i]=false;
            }
        }
    }
}
