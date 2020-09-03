package others.leetcodeWeek;
/* gh
 * 2020/8/12
 * 下午11:01
 */

import java.util.HashSet;
import java.util.Set;

public class LatinGame {
    public String toGoatLatin(String S) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder stb=new StringBuilder();
        String[] ss= S.split(" ");
        for (int i = 0; i < ss.length; i++) {
            String s1=ss[i];
            char ch=s1.charAt(0);
            StringBuilder stb1=new StringBuilder();
            if(set.contains(ch)){//元音
                stb1.append(s1);
            }else {//辅音
                stb1.append(s1.substring(1));
                stb1.append(ch);
            }
            stb1.append("ma");
            stb1.append(genA(i+1));
            stb.append(stb1).append(" ");
        }
        return stb.toString().trim();
    }

    public StringBuilder genA(int num){
        StringBuilder stb=new StringBuilder();
        for (int i = 0; i < num; i++) {
            stb.append("a");
        }
        return stb;
    }
}
