package others.回溯;
/* gh
 * 2020/8/20
 * 下午10:58
 */

import java.util.ArrayList;
import java.util.List;

public class DefStr {
    long index=0;
    String ret=null;
    public String kthString(int n, long k) {
        String str1="def";
        kthString0(k,n,"",str1);
        return ret;
    }

    public void kthString0(long k,int n,String str,String str1){
        if(ret==null&&n==0){
            index++;
            if(index==k){
                ret=str;
            }
        }
        char ch=str.charAt(str.length()-1);
        for (int i = 0; i < str1.length(); i++) {
            char ch1=str1.charAt(i);
            if(ch1!=ch){
                kthString0(k,n-1,str+ch1,str1);
            }
        }
    }

}

